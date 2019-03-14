<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
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
<div class="container">
    <div class="card">
        <form action="/addUser.action" method="post">
            <div class="card-header">
                <h1>添加用户</h1>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="username">用户名:</label><input id="username" type="text" name="user.username"
                                                             class="form-control" required>
                    <label for="password">密码:</label><input id="password" type="password" name="user.password"
                                                            class="form-control" required>
                    <label for="birthday">生日:</label><input id="birthday" type="date" name="user.birthday"
                                                            class="form-control">
                </div>
            </div>
            <div class="card-footer">
                <div class="form-inline">
                    <div class="mx-auto">
                        <button class="btn btn-primary" type="submit">
                            提交
                        </button>
                        <button class="btn btn-warning" type="reset">
                            清除
                        </button>
                        <button class="btn" type="button" onclick="window.location.href='/listUser.action'">
                            返回
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>