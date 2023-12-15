package common

object Pattern {
    fun namePatter(input: String):String{
        val len =20;
        return paddingSpaceBar(input,len- input.length);
    }

    fun pricePatter(input: String):String{
        //자릿수만큼  " 스페이스바 추가해주기.
        val len = 5;
        return paddingSpaceBar(input,len-input.length);
    }


    fun paddingSpaceBar(str:String,input:Int):String{
        val padding = "";
        for( i in 1..input){
            padding+" ";
        }

        return str+padding;
    }
}