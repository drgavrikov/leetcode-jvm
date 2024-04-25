/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/employee-importance/
 */
class Problem690 {
    class Employee(var id: Int, var importance: Int, var subordinates: List<Int>)

    fun getImportance(employees: List<Employee?>, id: Int): Int {

        val idToEmployee = employees.associateBy { employee -> employee!!.id }

        val used = mutableSetOf<Employee>()
        fun dfs(employee: Employee?) {
            if (employee == null) return
            if (employee in used) return
            used.add(employee)
            employee.subordinates.forEach { index ->
                dfs(idToEmployee.getValue(index))
            }
        }
        dfs(employees.firstOrNull { it?.id == id })
        return used.sumOf { it.importance }
    }
}

fun main() {
    val problem690 = Problem690()

    val employee1 = Problem690.Employee(1, 5, listOf(2, 3))
    val employee2 = Problem690.Employee(2, 3, listOf())
    val employee3 = Problem690.Employee(3, 3, listOf())
    check(problem690.getImportance(listOf(employee1, employee2, employee3), 1) == 11) { "Test 1 failed" }
}
