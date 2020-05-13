package redux

class ChangePresent(val lesson: Int, val student: Int) : RAction
class addforstudent (val studname: String, val studsurname: String) :RAction
class addforlesson (val less: String) :RAction
class deleteforstudent (val number: Int) :RAction
class deleteforlesson (val number: Int) :RAction
/*
class (val indexOfLesson: Int):RAction
class (val indexOfStudent:Int):RAction*/
