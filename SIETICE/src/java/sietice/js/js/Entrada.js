/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function toCadena(input){
    try{
        var s = input.value;
        var len = s.length;
        for(i = 0; i < len; i++){
            for(j = 0; j <= 9; j++){
                if(s.charAt(i) == ""+j){
                    s = s.replace(""+j,"");
                    i --;
                }
            }
            len = s.length;
        }
        input.value = s;
    }catch(er){
        alert(er);
    }
}

function toEntero(input){
    try{
        var s = input.value;
        var len = s.length;
        for(i = 0; i < len; i++){
            for(j = 0; j <= 9; j++){
                var c = s.charAt(i);
                if(isNaN(c)){
                    s = s.replace(""+c,"");
                    i --;
                }
            }
            len = s.length;
        }
        input.value = s;
    }catch(er){
        alert(er);
    }
}