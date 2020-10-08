var APP = function () {

    //iCheck
    var _master = null;
    var _quanbu = null;
    //用于存放id的数组
    var _idArray;

    //默认的Dropzone参数
    var defaultDropzoneOpts = {
        url: "",
        dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
        paramName: "dropFile", // 传到后台的参数名称
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 10, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传" + this.maxFiles + "个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
    };
    /**
     * 私有方法,初始化iCheck
     */
    var handlerInit = function () {
// 激活 iCheck
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        //全选按钮
        _master = $('input[type="checkbox"].minimal.master');
        //获取全部checkbox集合
        _quanbu = $('input[type="checkbox"].minimal.minimal');
    };
    /**
     * 全选功能
     */
    var handlerCheckBoxAll = function () {
        _master.on("ifClicked", function (e) {
            //返回true，没选中，false为选中
            if (e.target.checked) {
                _quanbu.iCheck("uncheck");
            } else {
                _quanbu.iCheck("check");
            }
        });
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();
        /**
         * 获取选中的id
         */
        _quanbu.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择，，请至少选择一项");
        } else {
            $("#modal-message").html("是否要删除选中内容");
        }
        $("#modal-default").modal("show");

        //绑定确定按钮事件
        $("#queding").bind("click", function () {
            del();
        });

        /**
         * 当前私有函数的私有函数，删除数据
         */
        function del() {

            $("#modal-default").modal("hide");
            //如果没有选择数据项的处理，则关闭模态框
            if (_idArray.length === 0) {
                //...
            }
            //删除操作
            else {
                //延时操作
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids": _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {
                            //删除成功
                            if (data.status === 200) {
                                window.location.reload();//刷新页面

                            }
                            //删除失败
                            else {
                                $("#queding").unbind("click");
                                $("#queding").bind("click", function () {
                                    $("#modal-default").modal("hide");
                                });

                                $("#modal-message").html(data.message);
                                $("#modal-default").modal("show");
                                //  _idArray.length=0;

                            }
                        }
                    });
                }, 500);

            }
        }

    };

    /**
     * 封装ZTree
     * @param url
     */
    var handlreInitZTree = function (url, autoParam, callback) {
        var setting = {
            view: {
                // 禁止多选
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam
            }
        };
        // 初始化 zTree 控件
        $.fn.zTree.init($("#myTree"), setting);
        //模态框确定按钮绑定事件
        $("#queding").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();


            //未选择节点
            if (nodes.length == 0) {
                alert("请先选择一个父节点");
            }
            //选择节点
            else {
                callback(nodes);
            }


        });
    };

    /**
     * 初始化dropzone
     * @param
     */
    var handlerInitDropZone = function (opts) {
        //关闭dropzone的自动发现功能
        Dropzone.autoDiscover = false;
        //继承
        $.extend(defaultDropzoneOpts, opts);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    };

    /**
     * 初始化DataTables相关属性
     */
    var handlerInitDataTables = function (url, columns) {
        var _dataTable = $("#datatable").DataTable({
            "paging": true,
            "lengthChange": false,
            "info": true,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function (settings) {
                handlerInit();
                handlerCheckBoxAll();
            }

        });
        return _dataTable;
    };

    /**
     * 查看详情,将jsp页面放入模态框中显示
     * @param url
     */
    var handlerShowDetail = function (url) {
        $.ajax({
            url: url,
            type: "GET",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };


    /**
     * 对外暴露方法
     */
    return {
        initCheckBox: function () {

            handlerInit();
            handlerCheckBoxAll();
        },
        getCheckbox: function () {
            return _quanbu;
        },
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },

        initDataTables: function (url, columns) {
            return handlerInitDataTables(url, columns);
        },
        showDetail: function (url) {
            handlerShowDetail(url);
        },
        initZTree: function (url, autoParam, callback) {
            handlreInitZTree(url, autoParam, callback);
        },
        initDropzone: function (opts) {
            handlerInitDropZone(opts);

        }
    }
}();

/**
 * 初始化CheckBox
 */
$(document).ready(function () {
    APP.initCheckBox();
});