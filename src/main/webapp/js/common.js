    $(function() {
        $('#button-submit').click(function() {
            var $uName = $('#username').val().trim();
            var $uPassword = $('#password').val().trim();
            var $uRepeatPassword = $('#repeatPassword').val().trim();
            var $uEmail = $('#email').val().trim();
            if ($uName == "" || $uPassword == "" || $uRepeatPassword == "" || $uEmail == "") {
                alert("用户信息填写不能为空");
                return false;
            }
            if ($uName.length < 6 || $uName.length > 20) {
                alert("用户名长度必须在6到20个字符之间！");
                return false;
            }
            if ($uPassword.lengthl < 6 || $uPassword.length > 20 || $uRepeatPassword.length < 6 || $uRepeatPassword.length > 20) {
                alert("密码长度必须在6到20个字符之间！");
                return false;
            }
            if ($uPassword != $uRepeatPassword) {
                alert("密码和重复密码必须相同！");
                return false;
            }
            alert("注册成功");
            return true;
        });
    });
    //当文档窗口发生改变时 触发  
    $(window).resize(function() {
        var windowHeight = $(window).height();
        var windowWidth = $(window).width();
        var headHeight = $('.head').height();
        var pictureHeight = $('.picture').height();
        var changeHeight = windowHeight - headHeight;
        var ulHeight = $('ul').height();
        var mtHeight = changeHeight - ulHeight - 170;
        // alert(windowWidth);
        if (windowWidth < 400) {
            // alert("我");
            $('.logoname').hide();
            $('.help').hide();
            $('.exit').hide();
        } else {
            $('.logoname').show();
            $('.help').show();
            $('.exit').show();
        }
        $('.left').css('height', changeHeight);
        $('.right').css('height', changeHeight);
        $('.picture').css('margin-top', mtHeight);
    });