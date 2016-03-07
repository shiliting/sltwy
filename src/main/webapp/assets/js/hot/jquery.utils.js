/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

$.extend({});

$.fn.extend({
    trim: function () {
        return $.trim(this.val());
    },
    lTrim: function () {
        return this.val().replace(/^\s+/, '');
    },
    rTrim: function () {
        return this.val().replace(/\s+$/, '');
    },

    setDisabled: function (disabled) {
        return this.each(function () {
            $(this).attr('disabled', disabled).css('opacity', disabled ? 0.5 : 1.0);
        });
    },
    setReadOnly: function (readonly) {
        return this.each(function () {
            $(this).attr('readonly', readonly).css('opacity', readonly ? 0.5 : 1.0);
        });
    },
    setChecked: function (checked, value) {
        return this.each(function () {
            if (value == undefined) {
                $(this).attr('checked', checked);
            } else if ($(this).val() == value.toString()) {
                $(this).attr('checked', checked);
            }
        });
    }
});

var J = J || {};

$.extend(
    J,
    {
        PostMethod: "post",
        GetMethod: "get",
        PageSize: 20,
        IsIE: $.browser.msie != undefined,
        IsIE6: $.browser.msie && parseInt($.browser.version) === 6,

        CopyText: function (obj) {
            var str = J.IsElement(obj) ? obj.value : ($(obj).size() > 0 ? $(obj).val() : obj);
            if (window.clipboardData && clipboardData.setData && window.clipboardData.setData("Text", str)) {
                return true;
            } else {
                if (J.IsElement(obj))
                    o.select();
                return false;
            }
        },
        AddBookMark: function (url, title) {
            try {
                if (window.sidebar) {
                    window.sidebar.addPanel(title, url, '');
                } else if (J.IsIE) {
                    window.external.AddFavorite(url, title);
                } else if (window.opera && window.print) {
                    return true;
                }
            } catch (e) {
                alert("Your browser does not support it.");
            }
        },
        SetHomePage: function (url) {
            try {
                document.body.style.behavior = 'url(#default#homepage)';
                document.body.setHomePage(url);
            } catch (e) {
                if (window.netscape) {
                    try {
                        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                    } catch (e) {
                        alert("Your browser does not support it.");
                    }
                    var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                    prefs.setCharPref('browser.startup.homepage', url);
                }
            }
        },

        GetCookie: function (name) {
            var r = new RegExp('(^|;|\\s+)' + name + '=([^;]*)(;|$)');
            var m = document.cookie.match(r);
            return (!m ? '' : decodeURIComponent(m[2]));
        },
        SetCookie: function (name, value, expire, domain, path) {
            var s = name + '=' + encodeURIComponent(value);
            if (!J.IsUndefined(path))
                s = s + '; path=' + path;
            if (expire > 0) {
                var d = new Date();
                d.setTime(d.getTime() + expire * 1000);
                if (!J.IsUndefined(domain))
                    s = s + '; domain=' + domain;
                s = s + '; expires=' + d.toGMTString();
            }
            document.cookie = s;
        },
        RemoveCookie: function (name, domain, path) {
            var s = name + '=';
            if (!J.IsUndefined(domain))
                s = s + '; domain=' + domain;
            if (!J.IsUndefined(path))
                s = s + '; path=' + path;
            s = s + '; expires=Fri, 02-Jan-1970 00:00:00 GMT';
            document.cookie = s;
        },

        IsUndefined: function (obj) {
            return typeof obj == 'undefined';
        },
        IsObject: function (obj) {
            return typeof obj == 'object';
        },
        IsNumber: function (obj) {
            return typeof obj == 'number';
        },
        IsString: function (obj) {
            return typeof obj == 'string';
        },
        IsElement: function (obj) {
            return obj && obj.nodeType == 1;
        },
        IsFunction: function (obj) {
            return typeof obj == 'function';
        },
        IsArray: function (obj) {
            return Object.prototype.toString.call(obj) === '[object Array]';
        },

        IsInt: function (str) {
            return /^-?\d+$/.test(str);
        },
        IsFloat: function (str) {
            return /^(-?\d+)(\.\d+)?$/.test(str);
        },
        IsIntPositive: function (str) {
            return /^[0-9]*[1-9][0-9]*$/.test(str);
        },
        IsFloatPositive: function (str) {
            return /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/.test(str);
        },
        IsLetter: function (str) {
            return /^[A-Za-z]+$/.test(str);
        },
        IsChinese: function (str) {
            return /^[\u0391-\uFFE5]+$/.test(str);
        },
        IsZipCode: function (str) {
            return /^[1-9]\d{5}$/.test(str);
        },
        IsEmail: function (str) {
            return /^[A-Z_a-z0-9-\.]+@([A-Z_a-z0-9-]+\.)+[a-z0-9A-Z]{2,4}$/.test(str);
        },
        IsMobile: function (str) {
            return /^1[1-9][0-9]{9}$/.test(str);
        },
        IsTel: function (str) {
            return /^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/.test(str);
        },
        IsUrl: function (str) {
            return /^(http:|ftp:)\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"])*$/.test(str);
        },
        IsIpAddress: function (str) {
            return /^(0|[1-9]\d?|[0-1]\d{2}|2[0-4]\d|25[0-5]).(0|[1-9]\d?|[0-1]\d{2}|2[0-4]\d|25[0-5]).(0|[1-9]\d?|[0-1]\d{2}|2[0-4]\d|25[0-5]).(0|[1-9]\d?|[0-1]\d{2}|2[0-4]\d|25[0-5])$/
                .test(str);
        },
        IsMoney: function (str) {
            return /^(0|-?[0-9]\d*(\.\d{1,2})?)$/.test(str);
        },
        IsUsername: function (str) {
            return /^[a-zA-Z0-9_]{4,16}$/.test(str);
        },
        Encode: function (str) {
            return encodeURIComponent(str);
        },
        Decode: function (str) {
            return decodeURIComponent(str);
        },
        FormatString: function () {
            if (arguments.length == 0)
                return '';
            if (arguments.length == 1)
                return arguments[0];
            var args = J.CloneArray(arguments);
            args.splice(0, 1);
            return arguments[0].replace(/{(\d+)?}/g, function ($0, $1) {
                return args[parseInt($1)];
            });
        },

        EscapeHtml: function (str) {
            return str.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
        },
        UnEscapeHtml: function (str) {
            return str.replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&nbsp;/g, " ").replace(/&quot;/g, "\"").replace(/&amp;/g, "&");
        },
        FilterHtml: function (str) {
            str = str.replace(/\<(.*?)\>/g, '', str);
            str = str.replace(/\<\/(.*?)\>/g, '', str);
            return str;
        },

        CloneArray: function (arr) {
            var cloned = [];
            for (var i = 0, j = arr.length; i < j; i++) {
                cloned[i] = arr[i];
            }
            return cloned;
        },

        GetKeyCode: function (e) {
            var evt = window.event || e;
            return evt.keyCode ? evt.keyCode : evt.which ? evt.which : evt.charCode;
        },
        CertainNumberContainPoint: function (event) {
            var e = event ? event : (window.event ? window.event : null);
            if (e.keyCode == 13) {
                e.keyCode = 9;
            }
            if ((e.keyCode < 48 || e.keyCode > 57)) {
                if ((e.keyCode != 8)) {
                    if ((e.keyCode < 96 || e.keyCode > 105) && e.keyCode != 190 && e.keyCode != 110) {
                        event.returnValue = false;
                    }
                }
            }
        },
        CertainNumber: function (event) {
            var e = event ? event : (window.event ? window.event : null);
            if (e.keyCode == 13) {
                e.keyCode = 9;
            }
            if ((e.keyCode < 48 || e.keyCode > 57)) {
                if ((e.keyCode != 8)) {
                    if ((e.keyCode < 96 || e.keyCode > 105)) {
                        event.returnValue = false;
                    }
                }
            }
        },
        EnterSubmit: function (e, v) {
            if (J.GetKeyCode(e) == 13) {
                if (J.IsFunction(v)) {
                    v();
                } else if (J.IsString(v)) {
                    $(v)[0].click();
                }
            }
        },
        CtrlEnterSubmit: function (e, v) {
            var evt = window.event || e;
            if (evt.ctrlKey && J.GetKeyCode(evt) == 13) {
                if (J.IsFunction(v)) {
                    v();
                } else if (J.IsString(v)) {
                    $(v)[0].click();
                }
            }
        },

        GetUrlQuery: function (key, Decode, url) {
            url = url || window.location.href;
            if (url.indexOf("#") !== -1)
                url = url.substring(0, url.indexOf("#"));
            var rts = [], rt;
            queryReg = new RegExp("(^|\\?|&)" + key + "=([^&]*)(?=&|#|$)", "g");
            while ((rt = queryReg.exec(url)) != null) {
                if (Decode && Decode == true)
                    rts.push(DecodeURIComponent(rt[2]));
                else
                    rts.push(rt[2]);
            }
            return rts.length == 0 ? '' : (rts.length == 1 ? rts[0] : rts);
        },

        PostJson: function (url, data, success, error, option) {
            var op = {
                type: 'POST',
                url: url,
                data: data,
                dataType: 'json',
                cache: false,
                success: function (data, textStatus) {
                    if (data == null || data == undefined) {
                        if (typeof error == 'function')
                            error();
                    } else {
                        if (typeof error == 'function')
                            success(data, textStatus);
                    }
                },
                error: error
            };
            $.extend(op, option);
            $.ajax(op);
        },
        GetJsonRespons: function (url, data, success, error, type) {
            var op = {
                type: type,
                url: url,
                data: data,
                dataType: 'json',
                success: function (data) {
                    if (data == null || data == undefined) {
                        if (typeof error == 'function')
                            error();
                    } else {
                        if (typeof success == 'function')
                            success(data);
                    }
                },
                error: error
            };
            $.ajax(op);
        },
        GetJson: function (url, data, success, error, option) {
            var op = {
                type: "get",
                async: false,
                url: url,
                data: data,
                dataType: "jsonp",
                jsonpCallback: "jsonpcallback",
                success: function (d, textStatus) {
                    if (d == null || d == undefined) {
                        if (typeof error == 'function')
                            error();
                    } else {
                        if (typeof error == 'function')
                            success(d, textStatus);
                    }
                },
                error: error
            };
            $.extend(op, option);
            $.ajax(op);
        },
        GetAjax: function (url, data, success, error, type, option) {
            type = type == "post" ? type : "get";
            var op = {
                type: type,
                url: url,
                data: data,
                success: function (d, textStatus) {
                    if (d == null || d == undefined) {
                        if (typeof error == 'function')
                            error();
                    } else {
                        if (typeof error == 'function')
                            success(d, textStatus);
                    }
                },
                error: error
            };
            $.extend(op, option);
            $.ajax(op);
        },
        ShowDialog: function (contentid, title, func1, func2) {
            $("#" + contentid).dialog({
                modal: true,
                width: 'auto',
                height: 'auto',
                resizable: false,
                title: title,
                position: ["50%", 60],
                buttons: {
                    "确定": func1,
                    "取消": func2
                },
                show: {
                    effect: "drop",
                    direction: "up"
                },
                hide: {
                    effect: "drop",
                    direction: "up"
                }
            });
        },
        ShowDialogButton: function (contentid, title, buttons) {
            $("#" + contentid).dialog({
                modal: true,
                width: 'auto',
                height: 'auto',
                resizable: false,
                title: title,
                position: ["50%", 60],
                buttons: buttons,
                show: {
                    effect: "drop",
                    direction: "up"
                },
                hide: {
                    effect: "drop",
                    direction: "up"
                }
            });
        },
        ShowDialog2: function (contentid, title, func1, func2, position) {
            $("#" + contentid).dialog({
                modal: true,
                width: 'auto',
                height: 'auto',
                resizable: false,
                title: title,
                position: position,
                buttons: {
                    "确定": func1,
                    "取消": func2
                },
                show: {
                    effect: "drop",
                    direction: "up"
                },
                hide: {
                    effect: "drop",
                    direction: "up"
                }
            });
        },
        PreloadImages: function () {
            for (var i = 0; i < arguments.length; i++) {
                var img = new Image();
                img.src = arguments[i];
            }
        },
        getQueryString: function (strName) {
            // /<summary>
            // /获取url 参数
            // /</summary>
            var strHref = window.document.location.href;
            var intPos = strHref.indexOf("?");
            var strRight = strHref.substr(intPos + 1);
            var arrTmp = strRight.split("&");
            for (var i = 0; i < arrTmp.length; i++) {
                var arrTemp = arrTmp[i].split("=");
                if (arrTemp[0].toUpperCase() == strName.toUpperCase())
                    return arrTemp[1];
            }
            if (arguments.length == 1)
                return "";
            if (arguments.length == 2)
                return arguments[1];
        },
        pageOutput: function (url, pageSize, pageIndex, pageCount, recordCount) {
            pageSize = parseInt(pageSize, 10);
            pageIndex = parseInt(pageIndex, 10);
            pageCount = parseInt(pageCount, 10);
            recordCount = parseInt(recordCount, 10);

            if (pageIndex < 1)
                pageIndex = 1;
            if (pageIndex > pageCount)
                pageIndex = pageCount;

            // Pager.Data.urlFormat = urlFormat;
            // Pager.Data.pageCount = pageCount;

            function _getLink(text, enabled, urlFormat, index) {
                if (enabled == false)
                    return J.FormatString(' <a class="button-white" style="filter:Alpha(Opacity=60);opacity:0.6;" href="javascript:void(0);"><span>{0}</span></a>',
                        text);
                else
                    return J.FormatString(' <a class="button-white" href="javascript:window.location.href=\'' + urlFormat + '\';"><span>{1}</span></a>', index, text);
            }

            var html = [];
            html.push('<div class="pager-bar">');
            html.push(J.FormatString('<div class="msg">共{0}条记录，当前第{1}/{2}，每页{3}条记录</div>', recordCount, pageIndex, pageCount, pageSize));
            html.push(_getLink('上一页', pageIndex > 1, url, pageIndex - 1));
            html.push(_getLink('下一页', pageCount > 0 && pageIndex < pageCount, url, pageIndex + 1));
            html.push('</div>');

            document.write(html.join(''));
        }
    });

var LoadObj = null;
var Index = {};
Index.LoadPaging = function (obj, pageIndex, pageSize, totalCount, callback) {
    // /<summary>
    // /分页函数 优化人：郭孟稳
    // /</summary>
    // /<param name="obj" type="Object">输出元素位置</param>
    // /<param name="pageIndex" type="String">当前页码</param>
    // /<param name="pageSize" type="jQuery">每页数量</param>
    // /<param name="totalCount" type="String">数据总数</param>
    // /<param name="callback" type="jQuery">回调函数</param>
    if (obj) {
        LoadObj = obj;
        if (totalCount == 0) {
            obj.html('');
            return;
        }
        var pageCount = totalCount % pageSize == 0 ? parseInt(totalCount / pageSize) : parseInt(totalCount / pageSize + 1);
        if (pageIndex <= 1)
            pageIndex = 1;
        if (pageIndex >= pageCount)
            pageIndex = pageCount;
        if (pageIndex == 1 && pageCount == 1) {
            obj.html('');
            return;
        }
        var html = '';
        if (pageIndex > 1)
            html += '<span class="first paginate_button"  onclick="Index.goTo(1,' + pageSize + ',' + totalCount + ',' + callback
                + ')">第一页</span><span class="previous paginate_button "  onclick="Index.goTo(' + (pageIndex - 1) + ',' + pageSize + ',' + totalCount + ',' + callback
                + ')">上一页</span>';
        var number = '<span>';
        for (m = pageIndex - 4; m <= pageIndex + 4; m++) {
            if (m > 0 && m <= pageCount) {
                number += '<span ' + (pageIndex == m ? ' class="paginate_active"' : 'class="paginate_button"') + ' onclick="Index.goTo(' + m + ',' + pageSize + ',' + totalCount
                    + ',' + callback + ')">' + m + '</span>';
            }
        }
        number += "</span>";
        html += number;
        if (pageIndex < pageCount)
            html += '<span class="next paginate_button"  onclick="Index.goTo(' + (pageIndex + 1) + ',' + pageSize + ',' + totalCount + ',' + callback
                + ')">下一页</span><span class="last paginate_button "  onclick="Index.goTo(' + pageCount + ',' + pageSize + ',' + totalCount + ',' + callback + ')">最后一页</span>';
        obj.html(html);
    }
}
Index.goTo = function (pageIndex, pageSize, totalCount, callback) {
    if (callback)
        callback(LoadObj, pageIndex, pageSize, totalCount, Index.loadlist);
}
Index.loadlist = function (obj, pageIndex, pageSize, totalCount) {
    Index.LoadPaging(obj, pageIndex, pageSize, totalCount, function (o, p, s, t) {
        Index.loadlist(o, p, s, t)
    });
}