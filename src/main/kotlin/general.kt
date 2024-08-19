import java.util.Scanner

class General(val scanner: Scanner) {

    fun menuOutput(title: String, items: List<String>, exit: String): Int? {
        println(title)
        println("0. $exit")
        items.forEachIndexed { index, item -> println("${index + 1} $item")}
        return userInput(items.size)
    }

    private fun userInput(maxOption: Int): Int? {
        val input = scanner.nextLine().toIntOrNull()
        return if(input in 0..maxOption) input else null
    }

    fun emptyInput(prompt: String): String{
        println(prompt)
        var input = scanner.nextLine()
        while(input.isEmpty()){
            println("Поле не может быть пустым. $prompt")
            input = scanner.nextLine()
        }
        return input
    }

}


