/** adrecommend_create.jsp */


/* create adpost - button:back */
function backToAdRecommendList(){
	//alert("backToAdPostList");
	location.href = "/acp/ad/adrcmd/list.html";
}


/* create adpost - button:save change,create */
function createAdRecommend() {
    //alert(JSON.stringify(businessObject));
    var businessObject = getAdRecommendObject();
    var param = JSON.stringify(businessObject);
    
    /* validating by business rule */
    /*
    var eventTitle = businessObject.title;
    if(isEmptyString(eventTitle)){
    	alert("WARNING: event title must not be empty!");
    	return;
    }
    var author = businessObject.author;
    if(isEmptyString(author)){
    	alert("WARNING: author must not be empty!");
    	return;
    }*/
    
    //execute saving
    $.ajax({
    	async	:	false,
    	type    :	"post",
        url     :	"/acp/ad/adrcmd/create",
        data	:	"jsonObjString="+param,
        dataType:	"json",
        timeout :	30000,
        
        success:function(msg){
        	alert("提示：新增成功！");
        	location.href="/acp/ad/adrcmd/list.html";
        },
        error:function(){
        	alert("错误：新增失败，请重新尝试！");
//            alert("ERROR: AdRcmd creating failed.");     
        },            
        complete: function(XMLHttpRequest, textStatus){
            //reset to avoid duplication
        }        
    });
}


/* create adpost - button:reset */
function resetCreateAdRecommend(){
	var p1 = $("#adUUID").val("");
	var p2 = $("#pageId").val("");
	var p3 = $("#pageName").val("");
	var p4 = $("#rcmdRank").val("");
	var p5 = $("#rcmdStatus").val(0);
}

function getAdRecommendObject(){
	
	var p1 = $("#adUUID").val();
	var p2 = $("#pageId").val();
	var p3 = $("#pageName").val();
	var p4 = $("#rcmdRank").val();
	var p5 = $("#rcmdStatus").val();
	
	var obj = {
		adUUID:p1,
		pageId:p2,
		pageName:p3,
		rcmdRank:p4,
		rcmdStatus:p5	
	};
	
	return obj;
}