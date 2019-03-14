<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <script src="/static/common_js/jquery.js"></script>
    <script src="/static/vue/vue.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
    <script src="/static/bootstrap/js/bootstrap-material-design.js"></script>
    <script src="/static/bootstrap/js/popper.js"></script>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-material-design.css"/>
</head>
<body>
<div class="container" id="App">
    <div class="card">
        <div class="card-header">
            <h1 class="text-center">用户列表</h1>
        </div>
        <div class="card-body">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <td colspan="6">
                        <a href="/signUp.action">添加用户</a>
                    </td>
                </tr>
                <tr>
                    <td>id</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>生日</td>
                    <td>uuid</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <#list page.beanList as bean>
                    <tr>
                        <td>${bean.id}</td>
                        <td>${bean.username}</td>
                        <td>${bean.password}</td>
                        <td><#if bean.birthday?exists>${bean.birthday}</#if></td>
                        <td>${bean.uuid}</td>
                        <td><a href="/delUser.action?uid=${bean.id}">删除</a>
                            <a href="/update.action?uid=${bean.id}">编辑</a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="card-footer">
            <div class="form-inline">
                <div class="m-auto">
                    <button class="btn" onclick="window.location.href='/listUser?requestPage=${page.currentPage-1}'">
                        上一页
                    </button>
                    当前第${page.currentPage}页/共${page.totalPage}页
                    <button class="btn" onclick="window.location.href='/listUser?requestPage=${page.currentPage+1}'">
                        下一页
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    var vm = new Vue({
        el: "#App",
        data: {},
        methods: {}
    });
</script>
</html>