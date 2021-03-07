var layer, $;
var element;
layui.use(["layer", "jquery", "element"], function () {
    element = layui.element;
    layer = layui.layer;
    $ = layui.jquery;
});

function noticeMsg(msg) {
    layer.msg(msg, {shade: true, shade: 0.3, time: 1500, icon: 0});
}

function successMsg(msg) {
    layer.msg(msg, {shade: true, shade: 0.3, time: 1500, icon: 1});
}

function failureMsg(msg) {
    layer.msg(msg, {shade: true, shade: 0.3, time: 1500, icon: 2});
}

function tipinfo(msg, obj) {
    if (obj == null || typeof obj == "undefined") {
        layer.msg("<font style='color:#fff' width='100%'>" + msg + "</font>", {
            time: 3000,
            offset: 80,
        });
    } else {
        layer.tips(msg, obj, {
            time: 2000,
            tips: [3, "#f44336"]
        });
    }
}

function openwindow(url, title, width, height, isfull, callback) {
    if (isfull) {
        /*width = "100%";
        height = "100%";*/
    } else {
        if ($(window).height() <= height) {
            height = $(window).height() - 40;
        }
        if ($(window).width() <= width) {
            width = $(window).width() - 40;
        }
        height = height + "px";
        width = width + "px";
    }
    layer.open({
        type: 2,
        title: title,
        anim: 0,
        shade: [0.5, "#393D49"],
        shadeClose: false,
        area: [width, height],
        resize: false,
        content: url,
        success: function (layero, index) {
            /*if (isfull) {
                layer.full(index);
            }*/
            loading();
        },
        end: function () { //销毁后触发
            if (callback != null) {
                callback();
            }
        }
    });
}

function edit(url, title, width, height, isfull, table, callback) {
    if (isfull) {
        /*width = "100%";
        height = "100%";*/
    } else {
        if ($(window).height() <= height) {
            height = $(window).height() - 40;
        }
        if ($(window).width() <= width) {
            width = $(window).width() - 40;
        }
        height = height + "px";
        width = width + "px";
    }
    layer.open({
        type: 2,
        title: title,
        content: url,
        area: [width, height],
        btn: ['确定', '取消'],
        yes: function (index, layero) {
            var iframeWindow = window['layui-layer-iframe' + index],
                submitID = 'save',
                submit = layero.find('iframe').contents().find('#' + submitID);
            iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                var field = data.field;
                if (callback != null) {
                    var result = callback(field);
                    if (!(typeof (result) === "undefined") && !result) {
                        return;
                    }
                }
                if (table != null) {
                    table.reload('userTable');
                }
                layer.close(index);
            });
            submit.trigger('click');
        }
    });
}

function detail(url, title, width, height, isfull, table) {
    if (isfull) {
       /* width = "100%";
        height = "100%";*/
    } else {
        if ($(window).height() <= height) {
            height = $(window).height() - 40;
        }
        if ($(window).width() <= width) {
            width = $(window).width() - 40;
        }
        height = height + "px";
        width = width + "px";
    }
    layer.open({
        type: 2,
        title: title,
        content: url,
        area: [width, height],
        btn: ['取消'],
        yes: function (index, layero) {
            if (table != null) {
                table.reload('userTable');
            }
            layer.close(index);
        }
    });
}

function closewindow(close) {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
    if (typeof (close) == "undefined") {
        return;
    }
    if (close == 1) {
        parent.reload();
    }
}

function loading(flag) {
    if (flag) {
        layer.load(0, {
            shade: [0.5, "#D6D6D6"]
        });
    } else {
        layer.closeAll("loading");
    }
}

function confirm(msg, ok, cancel) {
    layer.confirm(msg, {
            icon: 3,
            title: "提示"
        },
        function (index) {
            if (ok != null) {
                ok();
            }
            layer.close(index);
        },
        function (index) {
            if (cancel != null) {
                cancel();
            }
            layer.close(index);
        });
}