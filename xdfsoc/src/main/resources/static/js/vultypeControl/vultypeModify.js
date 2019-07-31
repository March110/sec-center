layui.use(['element', 'form', 'laydate', 'jquery', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    let id = window.location.href.split("=")[1];

    $.ajax({
        type: "get",
        url: nginx_url + "/selectVultypeById/" + id,
        success: function (result) {
            console.log(result);
            $("#id").val(result.id);
            $("#vulName").val(result.vulName);
            $("#vulDesc").val(result.vulDesc);
            $("#vulRes").val(result.vulRes);
        }
    });
    
    form.on('submit(modifyVultype)', function () {
        $.ajax({
            type: "PUT",
            url: nginx_url + '/updateVulType/' + id,
            data: $('#vultypeForm').serialize(),
            dataType: "json",
            success: function (result) {
            	layer.alert('success: '+nginx_url + '/updateVulType/' + id);
                if (result === "SUCCESS") {
                    layer.msg('更新成功', {
                        time: 800,
                        icon: 1
                    }, function () {
                        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });
                } else {
                    layer.msg('更新失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }
        });
     
        return false;
    });

    form.verify({
        fax: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^([0-9]{3,4}-)?[0-9]{7,8}$").test(value)){
                return '传真号码格式不正确';
            }
        },
        postcode: function (value, item) {
            if(!new RegExp("^[0-9]{6}$").test(value)){
                return '邮编格式不正确';
            }
        }
    });

});