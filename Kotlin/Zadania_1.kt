fun main() {
    z_1()

//    var a = readln().toInt()
//    var b = readln().toInt()
//    println(z_2(a, b))

//    var T = arrayOf(12, 2, 3)
    var S = IntArray(5) { i -> i} // size {1, 2, 3, ...}
    var M = intArrayOf(2, 4, 3)
    M.shuffle()
    M = z_4(M)
    println(M.toList())
//    for(x in M) print("$x ")
//    for (i in 0..M.size - 1) print("${M[i]} ")

}

fun z_1() {
    println("Hello World!")
}

// NWD modulo
fun z_2(a : Int, b : Int) : Int {
    var x = a
    var y = b
    var r : Int
    while (y > 0) {
        r = x % y
        x = y
        y = r
    }

    return  x
}

// Liczba doskonała
fun z_3(a : Int) : Boolean {
    var suma : Int = 0
    for(i in 1 .. a) {
        if (a % i == 0) {
            suma += i
        }
    }

    if (a == suma)
        return true
    else
        return false
}

// Sortowanie prze wybór
fun z_4(T : IntArray) : IntArray {
//    val M = T.copyOf()

    var ci : Int
    var temp : Int
    for (i in 0 until T.size - 1) {
        ci = i
        for (j in i + 1 until T.size) {
            if (T[j] < T[ci])
                ci = j
        }
        temp = T[ci]
        T[ci] = T[i]
        T[i] = temp
    }

    return T
}

// Zadanie 5 - Wzorzec fasady - Koszyk
//class Koszyk {
//    private int id;
//    public String opis;
//    public double kwota;
//}

// final (nie można dziedziczyć) / open
open class Koszyk(private val id : Int, var opis : String, var kwota : Float);
class Faktura(val id : Int, var wartosc : Float)
class Kurier(val id : Int, var nazwa : String)
class Zamowienie(var koszyk: Koszyk, var faktura: Faktura, var kurier: Kurier)

fun d_1() : Int {
    var s = 0
    for (i in 10 until 100) s += i

    return s
}

fun d_2(n: Int) : Int {
    var x = n
    var s = 0
    while (x > 0) {
        s += x % 10
        x /= 10
    }

    return s
}

fun d_3(n : Int) : IntArray {
    var T = IntArray(0)
    var i = 1
    do {
        if (n % i == 0)
            T += i
        i++
    } while (i <= n)

    return T
}

fun d_3v_2(n : Int) : MutableList<Int> {
    var T = mutableListOf(0)
    var i = 1
    do {
        if (n % i == 0)
            T.add(i)
        i++
    } while (i <= n)

    return T // .toList()
}

fun Fibo(n : Int) : Int {
    if (n == 1 || n == 2) return 1
    return Fibo(n - 1) + Fibo(n - 2)
}

fun FiboList(n : Int) : MutableList<Int> {
    val L = mutableListOf(0)
    for(i in 1 .. n) L.add(Fibo(i))

    return L
}

fun Silnia(n : Int) : Int {
    if (n == 0 || n == 1) return 1
    return n * Silnia(n - 1)
}

fun d_5(t : String) : Map<Int, Int> {
    val W = t.split(" ")
    val N = W.map { it.toInt() }
    val M = mutableMapOf<Int, Int>()

    for (n in N) {
//        M[w.toInt()] = Silnia(w.toInt())
        M[n] = Silnia(n)
    }

    return M
}
