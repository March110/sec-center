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

    $("#goToMod").click(function () {
        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭

    })

});