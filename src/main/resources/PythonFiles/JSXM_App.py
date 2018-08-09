# coding=utf-8
import time

import tornado.web
import torndb
import redis
import simplejson as json
import pandas as pd
from pandas import Series, DataFrame


def date_handler(obj):
    if hasattr(obj, 'isoformat'):
        return obj.isoformat()
    else:
        raise TypeError


class UpdateProjectHandler(tornado.web.RequestHandler):

    def get(self, *args, **kwargs):
        # 设置项目详情
        sql = 'SELECT userID, project.projectID,projectSerial,projectName,projectBudgetSum,projectStartTime,projectEndTime,projectStatus,projectComment,projectDelete,budgetID,username,departmentName,projectDepartmentID  FROM project left JOIN department ON projectDepartmentID=departmentID left JOIN `user` ON projectChargerID=userID'
        result = db.query(sql)
        # print(result)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Project:ID:" + str(i.get("projectID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()

        # 项目列表
        sql = 'SELECT project.projectID from project'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = str(i.get("projectID"))
            key = "Project:All:Default"
            #     print (key+value)
            pipe.zadd(key, i.get("projectID"), value)
        pipe.execute()

        # 所有用户的项目列表
        userList = r.zrange("User:All:Default", 0, -1)
        sql = 'SELECT project.projectSerial,project.projectID from project where projectChargerID = %s'
        pipe = r.pipeline(transaction=True)
        for j in userList:
            result = db.query(sql, j)
            for i in result:
                value = str(i.get("projectSerial"))
                key = "ProjectSerial:User:" + j
                pipe.zadd(key, value, i.get("projectID"))
        pipe.execute()
        self.write("success")

        # 用户的项目列表
        userList = r.zrange("User:All:Default", 0, -1)
        sql = 'SELECT project.projectSerial,project.projectID from project where projectChargerID = %s'
        pipe = r.pipeline(transaction=True)
        for j in userList:
            result = db.query(sql, j)
            for i in result:
                value = str(i.get("projectSerial"))
                key = "ProjectSerial:User:" + j
                pipe.zadd(key, value, i.get("projectID"))
        pipe.execute()


class UpdateProjectDetailHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        pID = self.get_argument("projectID")
        # 设置项目详情
        sql = 'SELECT userID, project.projectID,projectSerial,projectName,projectBudgetSum,projectStartTime,projectEndTime,projectStatus,projectComment,projectDelete,budgetID,username,departmentName,projectDepartmentID  FROM project left JOIN department ON projectDepartmentID=departmentID left JOIN `user` ON projectChargerID=userID where project.projectID = %s'
        result = db.query(sql, pID)
        # print(result)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Project:ID:" + str(i.get("projectID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()

        self.write("success")


class UpdateProjectDetailWithSerialHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        pID = self.get_argument("projectID")
        userID = self.get_argument("userID")
        # 设置项目详情
        sql = 'SELECT userID, project.projectID,projectSerial,projectName,projectBudgetSum,projectStartTime,projectEndTime,projectStatus,projectComment,projectDelete,budgetID,username,departmentName,projectDepartmentID  FROM project left JOIN department ON projectDepartmentID=departmentID left JOIN `user` ON projectChargerID=userID where project.projectID = %s'
        result = db.query(sql, pID)
        # print(result)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Project:ID:" + str(i.get("projectID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()

        # 项目列表
        sql = 'SELECT project.projectID from project'
        result = db.query(sql, userID)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = str(i.get("projectID"))
            key = "Project:All:Default"
            #     print (key+value)
            pipe.zadd(key, i.get("projectID"), value)
        pipe.execute()

        # 所有用户的项目列表
        userList = r.zrange("User:All:Default", 0, -1)
        sql = 'SELECT project.projectSerial,project.projectID from project where projectChargerID = %s'
        pipe = r.pipeline(transaction=True)
        for j in userList:
            result = db.query(sql, j)
            for i in result:
                value = str(i.get("projectSerial"))
                key = "ProjectSerial:User:" + j
                pipe.zadd(key, value, i.get("projectID"))
        pipe.execute()
        self.write("success")

        # 用户的项目列表
        userList = r.zrange("User:All:Default", 0, -1)
        sql = 'SELECT project.projectSerial,project.projectID from project where projectChargerID = %s'
        pipe = r.pipeline(transaction=True)
        for j in userList:
            result = db.query(sql, j)
            for i in result:
                value = str(i.get("projectSerial"))
                key = "ProjectSerial:User:" + j
                pipe.zadd(key, value, i.get("projectID"))
        pipe.execute()


class UpdateUserHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 所有用户列表
        sql = 'SELECT userID from user'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = str(i.get("userID"))
            key = "User:All:Default"
            #     print (key+value)
            r.zadd(key, value, value)
        sql = 'SELECT userID from user where permissionLevel =3 or permissionLevel =1'
        result = db.query(sql)

        for i in result:
            value = str(i.get("userID"))
            key = "User:Admin:Default"
            #     print (key+value)
            r.zadd(key, value, value)
        pipe.execute()
        # 设置用户信息缓存

        sql = 'select * from user '
        pipe = r.pipeline(transaction=True)

        for i in db.query(sql):
            key = "User:ID:" + str(i["userID"])
            value = json.dumps(i)
            pipe.set(key, value)
        pipe.execute()


class UpdateContractHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 用户的项目下的合同列表
        userList = r.zrange("User:All:Default", 0, -1)
        sql = 'SELECT contractSerial,contractID FROM contract WHERE projectID= %s'
        pipe = r.pipeline(transaction=True)
        for j in userList:
            for i in r.zrange("Project:User:" + j, 0, -1):
                for k in db.query(sql, i):
                    value = str(k.get("contractSerial"))
                    key1 = "ContractSerial:User:" + j + ":Project:" + i
                    key2 = "ContracSerialt:User:" + j
                    pipe.zadd(key1, value, k.get("contractID"), )
                    pipe.zadd(key2, value, k.get("contractID"))
        pipe.execute()

        # 设置合同详情
        sql = 'SELECT contractID as contractId,contractSerial,contractName,contractPartner,contractSignedTime,contractMoney,contractComment,projectSerial,contractDelete,contractOwner,contractContent FROM contract INNER JOIN project ON project.projectID = contract.projectID'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Contract:ID:" + str(i.get("contractId"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()


class UpdateDocumentHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 设置文档详情
        sql = 'SELECT documentID, documentSerial, documentName, documentUploadTime, documentOwner , documentComment, documentUrl, documentType, documentDelete, projectSerial , contractSerial FROM document INNER JOIN project ON document.`projectID` = project.`projectID` INNER JOIN contract ON document.contractID = contract.contractID'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Document:ID:" + str(i.get("documentID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()


class UpdateAssetHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 设置资产详情
        sql = 'SELECT assetID, assetSerial, assetName, assetSpec, assetModel , assetAmount, assetMoney, assetDate, assetOwner, assetComment , assetStatus, assetDelete, projectSerial, assetDepID FROM asset INNER JOIN project ON asset.projectID = project.projectID'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Asset:ID:" + str(i.get("assetID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()


class UpdateFinanceHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 设置财务详情
        sql = 'SELECT financeID,financeSerials,financeDate,financeName,financeMoney,financeStatus,financeDelete,borrowName,lendName,buyOrgFormInfo,buyMethodInfo,buyTypeInfo,payMethodInfo,projectSerial,financeBorrowerID,financeLenderID,financeTypeID,financeBuyOrgID,financeBuyMethodID,finance.payMethodID,contractSerial FROM finance INNER JOIN ( SELECT accountantID,accountantName AS borrowName FROM accountant) borrow ON financeBorrowerID=borrow.accountantID INNER JOIN ( SELECT accountantID,accountantName AS lendName FROM accountant) lend ON financeLenderID=lend.accountantID INNER JOIN buyorgform ON financeBuyOrgID=buyOrgFormID INNER JOIN buymethod ON financeBuyMethodID=buyMethodID INNER JOIN buytype ON financeTypeID=buyTypeID INNER JOIN paymethod ON finance.payMethodID=paymethod.`payMethodID` INNER JOIN project ON finance.`projectID`=project.`projectID` INNER JOIN contract ON finance.`contractID`=contract.`contractID`'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Finance:ID:" + str(i.get("financeID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()
		# 设置合同详情
        sql = 'SELECT contractID as contractId,contractSerial,contractName,contractPartner,contractSignedTime,contractMoney,contractComment,projectSerial,contractDelete,contractOwner,contractContent FROM contract INNER JOIN project ON project.projectID = contract.projectID'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Contract:ID:" + str(i.get("contractId"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()

class UpdateBudgetHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 设置预算详情
        sql = 'SELECT budgetdetail.budgetID,budgetSerial,project.projectBudgetSum,projectContractsSum,projectContractsPayed,projectContractsNotPayed,projectBudgetLeft,project.projectID,projectSerial,projectName,projectStartTime FROM budgetdetail INNER JOIN project ON budgetdetail.projectID=project.projectID'
        result = db.query(sql)
        pipe = r.pipeline(transaction=True)
        for i in result:
            value = json.dumps(i, default=date_handler)
            key = "Budget:ID:" + str(i.get("budgetID"))
            # print(key + value)
            pipe.set(key, value)
        pipe.execute()


class UpdateBaseDataHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 查 选择借方信息 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  借方下拉框
        sql2 = "SELECT accountantID,accountantName,accountantType,versionID FROM accountant inner join version on accountant.versionID = version.verisionID WHERE accountantType = 0 and versionBuildNum = %s"
        resultHtml = '<option value="">请选择贷方信息</option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'

            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["accountantID"] + '">' + j["accountantName"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "BorrowType:list"

        r.set(key, resultHtml)

        # 查 贷方下拉框 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  贷方下拉框
        sql2 = " SELECT accountantID,accountantName,accountantType,versionID FROM accountant inner join version on accountant.versionID = version.verisionID WHERE accountantType = 1 and versionBuildNum = %s"
        resultHtml = '<option value="">请选择贷方信息</option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'

            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["accountantID"] + '">' + j["accountantName"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "LendType:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  预算批复下拉框
        sql2 = " SELECT budgetReplyID,budgetReplyInfo,versionID FROM budgetreply inner join version on budgetreply.versionID = version.verisionID WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'

            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["budgetReplyID"] + '">' + j["budgetReplyInfo"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "BudgetReply:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  建设内容下拉框
        sql2 = " SELECT buildContentID,buildInfo,versionID FROM buildcontent inner join version on buildcontent.versionID = version.verisionID WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'
            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["buildContentID"] + '">' + j["buildInfo"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "BuildContent:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  采购方式下拉框
        sql2 = " SELECT buyMethodID,buyMethodInfo,versionID FROM buymethod inner join version on buymethod.versionID = version.verisionID WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'
            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["buyMethodID"] + '">' + j["buyMethodInfo"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "PurchaseWay:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  采购组织方式下拉框
        sql2 = " SELECT buyOrgFormID,buyOrgFormInfo,versionID FROM buyorgform inner join version on buyorgform.versionID = version.verisionID  WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'
            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["buyOrgFormID"] + '">' + j["buyOrgFormInfo"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "BuyOrgMethod:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  采购类型下拉框
        sql2 = " SELECT buyTypeID,buyTypeInfo,versionID FROM buytype inner join version on buytype.versionID = version.verisionID  WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'
            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["buyTypeID"] + '">' + j["buyTypeInfo"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "PurchaseType:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  部门下拉框
        sql2 = " SELECT departmentID,departmentName,versionID FROM department inner join version on department.versionID = version.verisionID  WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'
            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["departmentID"] + '">' + j["departmentName"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "Department:list"

        r.set(key, resultHtml)

        # 查 version
        sql1 = "select versionBuildNum from version order by verisionID desc "
        versionList = []
        for i in db.query(sql1):
            versionList.append(i["versionBuildNum"])

        # 查具体的  付款方式下拉框
        sql2 = " SELECT payMethodID,payMethodInfo,versionID FROM paymethod inner join version on paymethod.versionID = version.verisionID  WHERE versionBuildNum = %s"
        resultHtml = '<option value=""></option>'
        i = 0
        for versionBuildNum in versionList:
            if i == 0:
                resultHtml += '<optgroup label="' + versionBuildNum + '">'
            else:
                resultHtml += '<optgroup label="' + versionBuildNum + '（已失效）">'
            for j in db.query(sql2, versionBuildNum):
                resultHtml += '<option value="' + j["payMethodID"] + '">' + j["payMethodInfo"] + '</option>'
            resultHtml += '</optgroup>'
            i += 1

        # resultHtml += '</select>'

        # print(resultHtml)

        # value = json.dumps(resultList)
        key = "PayMethod:list"

        r.set(key, resultHtml)


class UpdatePermissionHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        # 权限下拉框
        sql = 'SELECT permissionID,url,LEVEL,permissionComment FROM permission'
        result = db.query(sql)
        value = json.dumps(result, default=date_handler)
        key = "Level:list"
        r.set(key, value)

        # 设置权限缓存
        sql = " select * from permission"
        pipe = r.pipeline(transaction=True)
        for i in db.query(sql):
            pipe.sadd("Permission", i["url"] + ":" + str(i["level"]))
        pipe.execute()


class UpdateNetGraphHandler(tornado.web.RequestHandler):
    def get(self, *args, **kwargs):
        sql = 'select username, userID from user'
        userFrame = DataFrame(db.query(sql))
        sql = 'select projectID, projectName as name, IFNULL(projectBudgetSum,9000)  as size, IFNULL(projectChargerID,0)  as projectChargerID, username from project inner join user on projectChargerID = userID order by projectChargerID desc'
        projectFrame = DataFrame(db.query(sql))
        sql = 'select contractID, contractName as name, 10000 as size, projectID FROM contract order by projectID desc'
        contractFrame = DataFrame(db.query(sql))
        sql = 'select financeID, financeName as name, financeMoney as size, contractID FROM finance order by financeID desc'
        financeFrame = DataFrame(db.query(sql))
        contractFrame

        resultDict = {}
        resultDict["name"] = '金审平台'
        resultDict["size"] = str(18000)
        resultDict["children"] = []

        for indexs in userFrame.index:
            userNode = {}
            userNode["name"] = str(userFrame.loc[indexs].values[1])
            userNode["userID"] = str(userFrame.loc[indexs].values[0])
            userNode["size"] = str(8000)
            userNode["children"] = []

            for indexs in projectFrame[projectFrame["projectChargerID"] == int(userNode["userID"])].index:
                projectNode = {}
                projectNode["name"] = str(projectFrame.loc[indexs].values[0])
                projectNode["size"] = str(projectFrame.loc[indexs].values[3])
                projectNode["projectID"] = str(projectFrame.loc[indexs].values[2])
                projectNode["children"] = []

                for indexs in contractFrame[contractFrame["projectID"] == int(projectNode["projectID"])].index:
                    contractNode = {}
                    contractNode["name"] = str(contractFrame.loc[indexs].values[1])
                    contractNode["size"] = str(contractFrame.loc[indexs].values[3])
                    contractNode["contractID"] = str(contractFrame.loc[indexs].values[0])
                    contractNode["children"] = []

                    for indexs in financeFrame[financeFrame["contractID"] == int(contractNode["contractID"])].index:
                        financeNode = {}
                        financeNode["name"] = str(financeFrame.loc[indexs].values[2])
                        financeNode["size"] = str(financeFrame.loc[indexs].values[3])
                        #             financeNode["children"] = []

                        contractNode["children"].append(financeNode)
                    projectNode["children"].append(contractNode)
                userNode["children"].append(projectNode)
            resultDict["children"].append(userNode)
        r.set("NetGraph", json.dumps(resultDict, ensure_ascii=False))


class UpdateNewVersionHandler(tornado.web.RequestHandler):
    def set_default_headers(self):
        self.set_header('Access-Control-Allow-Origin', '*')
        self.set_header('Access-Control-Allow-Headers', '*')
        self.set_header('Access-Control-Max-Age', 1000)
        self.set_header('Content-type', 'application/json')
        self.set_header('Access-Control-Allow-Methods', 'POST, GET, OPTIONS')
        self.set_header('Access-Control-Allow-Headers',
                        'Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, X-Requested-By, Access-Control-Allow-Methods')

    def post(self, *args, **kwargs):
        print(self.request.body)
        pass


application = tornado.web.Application([
    (r"/updateProject", UpdateProjectHandler),
    (r"/updateProjectDetail", UpdateProjectDetailHandler),
    (r"/updateProjectDetailWithSerial", UpdateProjectDetailWithSerialHandler),
    (r"/updateUser", UpdateUserHandler),
    (r"/updateDocument", UpdateDocumentHandler),
    (r"/updateAsset", UpdateAssetHandler),
    (r"/updateContract", UpdateContractHandler),
    (r"/updateFinance", UpdateFinanceHandler),
    (r"/updateBudget", UpdateBudgetHandler),
    (r"/updateBaseData", UpdateBaseDataHandler),
    (r"/updatePermission", UpdatePermissionHandler),
    (r"/updateNetGraph", UpdateNetGraphHandler),
    (r"/updateNewVersion", UpdateNewVersionHandler)
])

if __name__ == "__main__":
    db = torndb.Connection("192.168.55.121:3306", "jinshenxiangmu",
                           user="root", password="233")
pool = redis.ConnectionPool(host='192.168.55.121', port=6379, password='foobar', decode_responses=True)
# pool = redis.ConnectionPool(host='123.206.254.42', port=6379, password='#q0AakIO8u*MIG*e', decode_responses=True)
r = redis.Redis(connection_pool=pool)
application.listen(8002)
tornado.ioloop.IOLoop.instance().start()
