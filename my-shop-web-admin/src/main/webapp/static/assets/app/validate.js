/**
 * 函数对象
 */
var Validate = function () {

    /**
     * 初始化 validate
     */

    var handlerInit = function () {
        $.validator.addMethod("mobile", function (value, element) {
            var length = value.length;
            var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");


        $("#123inputForm").validate({

            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });


    };

    return {
        init: function () {
            handlerInit();
        }

    }

}();

$(document).ready(function () {
    Validate.init();
});