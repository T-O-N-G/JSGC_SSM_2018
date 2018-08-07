package util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HdfsUtil {
    private static Configuration conf = new Configuration();
    private static final String HADOOP_URL="hdfs://L0:8020";
    private static FileSystem fs;
    private static final String INDEX_DIR="C://FileIndex//";
    static{
        System.setProperty("hadoop.home.dir", "C:\\Program Files\\hadoop-2.7.1\\");
        try {
            FileSystem.setDefaultUri(conf, HADOOP_URL);
            fs = FileSystem.get(conf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String uploadFromUser(HttpServletRequest request,MultipartFile myfile,Path targetPath) throws IOException {
        String oldFileName = myfile.getOriginalFilename(); // 获取上传文件的原名
        String path=request.getSession().getServletContext().getRealPath("/upload/batchUploadContracts");
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 新的文件
        String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
        Path localPath= new Path(dir + "\\" + newFileName);
        File newFile = new File(dir + "\\" + newFileName);
        // 将内存中的数据写入磁盘
        myfile.transferTo(newFile);
        if(!fs.exists(targetPath)) {
            System.out.println(fs.mkdirs(targetPath));
        }
        fs.copyFromLocalFile(localPath,targetPath);
        String dfsPath=targetPath.toString()+"/"+newFileName;
        String displayPath=targetPath.toString()+"/"+oldFileName;
        makeIndex(newFile,dfsPath,displayPath);
        newFile.delete();
        return dfsPath;
    }
    public static void makeIndex(File file,String dfsPath,String displayPath) throws IOException {
        String content;//正文内容
        String fileName=file.getName();
        if(fileName.substring(fileName.lastIndexOf(".")+1).equals("doc")){
            HWPFDocument doc=new HWPFDocument(new FileInputStream(file));
            content=doc.getDocumentText();
            doc.close();
        }else if(fileName.substring(fileName.lastIndexOf(".")+1).equals("docx")){
            XWPFDocument xdoc = new XWPFDocument(new FileInputStream(file));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            content=extractor.getText();
            xdoc.close();
        }else {
            FileReader reader=new FileReader(file);
            BufferedReader bReader=new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s = "";
            while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            }
            content = sb.toString();
            bReader.close();
            reader.close();
        }
        Analyzer analyzer=new IKAnalyzer();
        Directory directory= FSDirectory.open(new File(INDEX_DIR));
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);

        Document document=new Document();
        document.add(new TextField("displayPath",displayPath, Field.Store.YES));
        document.add(new TextField("filePath",dfsPath, Field.Store.YES));
        document.add(new TextField("content",content, Field.Store.YES));
        indexWriter.addDocument(document);
        indexWriter.commit();
        indexWriter.close();
    }
    public static List<DisplayAndRealPath> searchIndex(String queryContent){
        List<DisplayAndRealPath> searchOutCome=new ArrayList<>();
        try{
            FSDirectory directory = FSDirectory.open(new File(INDEX_DIR));
            Analyzer analyzer = new IKAnalyzer();
            DirectoryReader ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);

            QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "content", analyzer);
            Query query = parser.parse(queryContent);

            ScoreDoc[] hits = isearcher.search(query, null, 50).scoreDocs;

            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
//                System.out.println("____________________________");
//                System.out.println(hitDoc.get("filePath"));
                searchOutCome.add(new DisplayAndRealPath(hitDoc.get("displayPath"),hitDoc.get("filePath")));
//                System.out.println("____________________________");
            }
            ireader.close();
            directory.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return searchOutCome;
    }
    public static class DisplayAndRealPath{
        String displayPath;
        String realPath;
        public DisplayAndRealPath(String displayPath, String realPath) {
            this.displayPath = displayPath;
            this.realPath = realPath;
        }

        public String getRealPath() {
            return realPath;
        }
        public void setRealPath(String realPath) {
            this.realPath = realPath;
        }
        public String getDisplayPath() {
            return displayPath;
        }
        public void setDisplayPath(String displayPath) {
            this.displayPath = displayPath;
        }

        @Override
        public String toString() {
            return "DisplayAndRealPath{" +
                    "displayPath='" + displayPath + '\'' +
                    ", realPath='" + realPath + '\'' +
                    '}';
        }
    }

}
