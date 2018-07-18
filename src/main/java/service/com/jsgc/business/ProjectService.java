package service.com.jsgc.business;

import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Project;
import util.com.jsgc.RequestPage;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    public List<Project> searchByConditions(RequestPage rp, ProjectSearchConditions psc){
//        projectMapper.searchByConditions();
        List<Project> ls=new ArrayList<Project>();
        Project a=new Project();
        Project b=new Project();
        ls.add(a);
        ls.add(b);
        return(ls);
    }
}
