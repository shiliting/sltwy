/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

/**
 * Created by allan on 1/7/16.
 */
jQuery.extend(jQuery.validator.messages, {
    required: "该信息必填",
    remote: "请修正该字段",
    email: "请输入正确格式的电子邮件",
    url: "请输入合法的网址",
    date: "请输入合法的日期",
    dateISO: "请输入合法的日期 (ISO).",
    number: "请输入合法的数字",
    digits: "只能输入整数",
    creditcard: "请输入合法的信用卡号",
    equalTo: "请再次输入相同的值",
    accept: "请输入拥有合法后缀名的字符串",
    maxlength: jQuery.validator.format("文本信息长度不得超过{0}"),
    minlength: jQuery.validator.format("文本信息长度不得小于{0}"),
    rangelength: jQuery.validator.format("长度介于 {0} 和 {1} 之间"),
    range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
    max: jQuery.validator.format("请输入一个最大为{0} 的值"),
    min: jQuery.validator.format("请输入一个最小为{0} 的值")
});


/**通用自定义验证方法**/
$(document).ready(function () {
    $.validator.addMethod("isHundred", function (value, element) {
        if (value.length == 0) {
            return false;
        }
        if (value < 100) {
            return false;
        }
        if (value % 100 == 0) {
            return true;
        } else {
            return false;
        }
    }, "请输入已百为单位的正整数");

    $.validator.addMethod("maxTo", function (value, element, param) {
        if (parseInt(value) > parseInt($(param).val())) {
            return true;
        } else {
            return false;
        }
    }, "输入的值必须大于");

    $.validator.addMethod("minTo", function (value, element, param) {
        if (parseInt(value) < parseInt($(param).val())) {
            return true;
        } else {
            return false;
        }
    }, "输入的值必须小于");

    $.validator.addMethod("mobile", function (value, element) {
        if (/^1[1-9][0-9]{9}$/.test(value)) {
            return true;
        } else {
            return false;
        }
    }, "请输入合法的手机号码");
});
/**通用自定义验证方法**/

/**通用规则rules**/
var commonRules = {
    /**
     * 区间范围内的数字
     */
    rangeNumber: function (min, max) {
        if (min == null && max == null) {
            return {
                required: true,
                number: true
            }
        }
        if (min == null) {
            return {
                required: true,
                number: true,
                max: max
            }
        }
        if (max == null) {
            return {
                required: true,
                number: true,
                min: min
            }
        }
        return {
            required: true,
            number: true,
            range: [min, max]
        }
    },
    rangeDigits: function (min, max) {
        if (min == null && max == null) {
            return {
                required: true,
                digits: true
            }
        }
        if (min == null) {
            return {
                required: true,
                digits: true,
                max: max
            }
        }
        if (max == null) {
            return {
                required: true,
                digits: true,
                min: min
            }
        }
        return {
            required: true,
            digits: true,
            range: [min, max]
        }
    }
}
