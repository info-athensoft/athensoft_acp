/** item_category_list.jsp */

/* list item category - init */
var ItemCategoryList = function () {

    var initPickers = function () {
        //init date pickers
        $('.date-picker').datepicker({
//            rtl: Metronic.isRTL(),
            rtl: App.isRTL(),
            autoclose: true
        });
    }

    var handleProducts = function() {
        var grid = new Datatable();

        grid.init({
            src: $("#datatable_itemCategoryList"),
            onSuccess: function (grid) {
            	//alert("success");
            },
            onError: function (grid) {
                // execute some code on network or other general error
            	alert("onError");
            },
            loadingMessage: 'Loading ...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 

                // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
                // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
                // So when dropdowns used the scrollable div should be removed. 
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>t<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>",

                "lengthMenu": [
                    [2,10, 20, 50, 100, 150, 200],
                    [2,10, 20, 50, 100, 150, 200] // change per page values here 
                ],
                "pageLength": 200, // default record count per page
                "ajax": {
                    "url": "/acp/item/categoryListData", // ajax source
                }
            	//,
                //"order": [
                 //   [1, "asc"]
                //] // set first column as a default sort by asc
            	//modified by Athens on 2017-06-06
            
            }
        });

         // handle group action submit button click
        grid.getTableWrapper().on('click', '.table-group-action-submit', function (e) {
        	//alert("getTableWrapper");
            e.preventDefault();
            var action = $(".table-group-action-input", grid.getTableWrapper());
            
            //alert(action.val());
            
            if (action.val() != "" && grid.getSelectedRowsCount() > 0) {
                grid.setAjaxParam("customActionType", "group_action");
                grid.setAjaxParam("customActionName", action.val());
                grid.setAjaxParam("id", grid.getSelectedRows());
                
                //modified by Athens
                var eventUUIDArray = grid.getSelectedRows();
                var newsStatus = action.val();
                groupUpdateStatus(eventUUIDArray,newsStatus);
                //end-of-modified
                
                //grid.getDataTable().ajax.reload();
                //grid.getDataTable().ajax.url("/acp/events/eventsNewsListData").load();
                //grid.getDataTable().ajax.reload();
                grid.clearAjaxParams();
                
                
            } else if (action.val() == "") {
                Metronic.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'Please select an action',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            } else if (grid.getSelectedRowsCount() === 0) {
                Metronic.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'No record selected',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            }
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            handleProducts();
            initPickers(); 
        }

    };

}();


/* list news - button:group update status */
function groupUpdateStatus(eventUUIDArray,newsStatus){
	//alert("groupUpdateStatus()");
    //alert(eventUUIDArray+":"+newsStatus);
	
    //execute saving
    $.ajax({
        type    :    "post",
        url        : "updateNewsGroup?eventUUIDArray="+eventUUIDArray+"&newsStatus="+newsStatus,
        dataType:    "json",
        timeout :     30000,
        
        success:function(msg){
            location.href="eventsNewsList";
        	//alert("INFO: News status updated.");
        },
        error:function(){
            alert("ERROR: News updating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/* list news - datatable:button:filter search */
function filterSearch(){
	
//	alert("do filterSearch()");
//	create a json object
    var p1 = $("#categoryId").val();
    var p2 = $("#parentId").val();
    var p3 = $("#categoryCode").val();
    var p4 = $("#categoryName").val();
    var p5 = $("#categoryDesc").val();
//    var p6a = $("#levelFrom").val();
    var p6b = $("#levelTo").val();
    var p7 = $("#categoryStatus").val();

    
//	validate
//	if(!isNonNegativeInteger(p6a)){
//		p6a = "";
//		$("#levelFrom").val("");
//	}
	if(!isNonNegativeInteger(p6b)){
		p6b = "";
		$("#levelTo").val("");
	}
//	isNonNegativeInteger(p6b);
//	alert(p5a+" "+p5b);
  
    var businessObject =
    {
    		categoryId  	:	p1,
    		parentId    	:	p2,
    		categoryCode    :	p3,
    		categoryName	:	p4,            
    		categoryDesc	:	p5,            
//    		levelFrom 		:   p6a,            
    		levelTo 		:   p6b,            
    		categoryStatus  :   p7,
    };

    var dt = $("#datatable_itemCategoryList").DataTable();
    
    var x = dt.ajax.url("categorySearchFilterData?itemJSONString="+JSON.stringify(businessObject)).load();
    
    
}


/* list news - datatable:button:filter reset */
function filterReset(){
//	alert("do filterReset()");
	var p1 = $("#categoryId").val("");
    var p2 = $("#parentId").val("");        
    var p3 = $("#categoryCode").val("");
    var p4 = $("#categoryName").val("");
    var p5 = $("#categoryDesc").val("");
//    var p6a = $("#levelFrom").val("");
    var p6b = $("#levelTo").val("");
    var p7 = $("#categoryStatus").val(0);
}