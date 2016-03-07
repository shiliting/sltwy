/**
 * 新增或修改代理商
 * Created by cwb on 2016/2/18.
 */
$("#qualify").live("change",function() {
    imgUpload();
});
function imgUpload() {
    var qualifyUri = $("#qualifyUri").val();
    $.ajaxFileUpload
    ({
        url: 'uploadImg',
        fileElementId: 'qualify',
        dataType: 'json',
        data:{
            qualifyUri:qualifyUri
        },
        type:'post',
        success:function(result){
            if(result.code==2000){
                $("#qualifyUri").val(result.data[0])
                $("#previewImg").attr("src",result.data[1]);
            }else {
                alert(result.msg);
            }
        }
    });
}