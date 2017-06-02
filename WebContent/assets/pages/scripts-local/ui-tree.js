var UITree = function () {

    var handleSample1 = function () {

        $('#tree_1').jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                }            
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            },
            "plugins": ["types"]
        });

        // handle link clicks in tree nodes(support target="_blank" as well)
        $('#tree_1').on('select_node.jstree', function(e,data) { 
            var link = $('#' + data.selected).find('a');
            if (link.attr("href") != "#" && link.attr("href") != "javascript:;" && link.attr("href") != "") {
                if (link.attr("target") == "_blank") {
                    link.attr("href").target = "_blank";
                }
                document.location.href = link.attr("href");
                return false;
            }
        });
    }

    var handleSample2 = function () {
        $('#tree_2').jstree({
            'plugins': ["wholerow", "checkbox", "types"],
            'core': {
                "themes" : {
                    "responsive": false
                },    
                'data': [{
                        "text": "Same but with checkboxes",
                        "children": [{
                            "text": "initially selected",
                            "state": {
                                "selected": true
                            }
                        }, {
                            "text": "custom icon",
                            "icon": "fa fa-warning icon-state-danger"
                        }, {
                            "text": "initially open",
                            "icon" : "fa fa-folder icon-state-default",
                            "state": {
                                "opened": true
                            },
                            "children": ["Another node"]
                        }, {
                            "text": "custom icon",
                            "icon": "fa fa-warning icon-state-warning"
                        }, {
                            "text": "disabled node",
                            "icon": "fa fa-check icon-state-success",
                            "state": {
                                "disabled": true
                            }
                        }]
                    },
                    "And wholerow selection"
                ]
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            }
        });
    }

    var contextualMenuSample = function() {
    	
    	$("#tree_search_input").keyup(function() {

            var searchString = $(this).val();
            $('#tree_3').jstree('search', searchString);
        });

        $("#tree_3").jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                }, 
                // so that create works
                "check_callback" : true,
                'data': jsTreeData
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            },
            "state" : { "key" : "demo2" },
            "search": {
                "case_insensitive": true,
                "show_only_matches" : true
            },
            "plugins" : [ "contextmenu", "dnd", "state", "types", "search" ]
        })
/*        .on('changed.jstree', function (e, data) {
//        	alert($("#tree_3").jstree().get_selected(true)[0].text); //ok
//        	alert(data.instance.get_node(data.selected[0]).text); //ok
		    var i, j, r = [];
		    for(i = 0, j = data.selected.length; i < j; i++) {
		      r.push(data.instance.get_node(data.selected[i]).text);
		    }
//		    $('#event_result').html('Selected: ' + r.join(', '));
		  }) */
		  .on("move_node.jstree", function (e, data) {
			   //data.node, data.parent, data.old_parent
			   var orig = data.node.state.key; //.text ; //.id
			   var dest = data.instance.get_node(data.node.parent).state.key; //.text;
			   $.ajax({
					type:"post",
					url:"dragAndDropResultSaved",
					dataType:"json",
					data: {	"orig" : orig, "dest" : dest},
					timeout : 5000,
					success:function(data){	
						$('#event_result').html('Orig : ' + data.orig + '&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Dest : ' + data.dest);
					}		
				}); 
//			   $('#event_result').html('Orig : ' + orig + '      Dest : ' + dest);
			});
    }

     var ajaxTreeSample = function() {

        $("#tree_4").jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                }, 
                // so that create works
                "check_callback" : true,
                'data' : {
                    'url' : function (node) {
                      return '../demo/jstree_ajax_data.php';
                    },
                    'data' : function (node) {
                      return { 'parent' : node.id };
                    }
                }
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            },
            "state" : { "key" : "demo3" },
            "plugins" : [ "dnd", "state", "types" ]
        });
    
    }


    return {
        //main function to initiate the module
        init: function () {

            handleSample1();
            handleSample2();
            contextualMenuSample();
            ajaxTreeSample();

        }

    };

}();

if (App.isAngularJsApp() === false) {
    jQuery(document).ready(function() {    
       UITree.init();
    });
}