<!DOCTYPE html>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<html lang="en">

<body>
Date: ${time?date}
<br>
Time: ${time?time}
<br>
Message: ${message}

<div id="app">
    {{ message }}
</div>
</body>
<script src="/js/hello.js"></script>
</html>