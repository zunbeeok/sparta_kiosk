package bank


//카카오페이, 네이버페이등 선택해서 다른게 출력 할 수 있게끔
//신용카드, 현금, 카카오페이, 네이버페이 (println 시에 다르게 출력할 수 있게끔)
abstract class Bank {
    abstract fun payment(money:Int):Int;
}
