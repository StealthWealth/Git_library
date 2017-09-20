
$(function() {  
    var code = 9999; 
    function codes(){
    	
        var ranColor = '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).slice(-6); // 
    	// alert(ranColor)
    	var ranColor2 = '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).slice(-6); 
     	var num1 = Math.floor(Math.random() * 100);  
        var num2 = Math.floor(Math.random() * 100);  
        code = num1 + num2;  
        
        $("#code").html(num1 + "+" + num2 + "=?");  
        if ($("#code").hasClass("nocode")) {  
            $("#code").removeClass("nocode");  
            $("#code").addClass("code"); 
           
        }  
        $("#code").css('background',ranColor);
         $("#code").css('color',ranColor2);

    }
    codes()
   
//    $("#input").blur('click',codes);
      
    $("#yz").blur(function(){ 
        if ($("#yz").val() == code && code != 9999) {  
            
        } else {  
        	$("#yz").val("");
            alert("验证码错误");  
        }  
    });  
    
    
    $("#bbb").blur(function(){ 
        if ($("#bbb").val() != $("#aaa").val()) {  
        	alert("对不起，您2次输入的密码不一致");
        	$("#password").val("");
        	$("#passwordConfirm").val("");
        }
        
    }); 
    
    
    
    
    
    
    
});  
