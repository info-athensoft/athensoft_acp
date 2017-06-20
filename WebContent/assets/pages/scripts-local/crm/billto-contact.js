/**
 * Package:	content
 * Module:  event-news system
 */

/* event news - global variables and functions*/
function getBusinessObject(){	
//	create a json object
    var p1 = $("#globalId").val();
    var p2 = $("#eventUUID").val();        
    var p3 = $("#title").val();
    var p4 = $("#author").val();
    var p5 = $("#postDatetime").val();
    var p6 = $("#viewNum").val();
    var p7 = $("#descShort").val();
    var p8 = $("#descLong").val();
    var p9 = $("#eventClass").val();
    var p10 = $("#eventStatus").val();
    
    var businessObject =
    {
    		globalId    :    p1,
    		eventUUID   :    p2,
    		title    	:    p3,
    		author    	:    p4,
    		postDatetime:    p5,            
    		viewNum    	:    p6,            
    		descShort   :    p7,
    		descLong	:    p8,
    		eventClass  :    p9,
    		eventStatus	:    p10
    };
    
    return businessObject;
}
