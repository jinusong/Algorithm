class Solution {
    fun solution(p: String): String {
        return if (rightBracket(p))
            p
        else
            convertBracket(p)
    }

    private fun rightBracket(p: String): Boolean {
        var tempInt = 0
        for (i in 0 until p.length) {
            if (tempInt < 0) return false
            if (p[i] == '(') tempInt++
            if (p[i] == ')') tempInt--
        }
        return true
    }

    private fun convertBracket(p: String): String {
        if (p.isEmpty()) return ""

        val u = balancedBracket(p)
        val v = p.substring(u.length)
        val sb = StringBuilder()

        if (rightBracket(u)) {
            sb.append(u)
            sb.append(convertBracket(v))
            return sb.toString()
        } else {
            sb.append("(")
            sb.append(convertBracket(v))
            sb.append(")")
            sb.append(removeAndReverse(u))
            return sb.toString()
        }
    }

    private fun balancedBracket(w: String): String {
        val sb = StringBuilder()
        var tempInt = 0

        for (i in 0 until w.length) {
            val c = w[i]

            if (c == '(')
                tempInt++
            if (c == ')')
                tempInt--
            sb.append(c)

            if (i >= 1 && tempInt == 0) return sb.toString()
        }
        return sb.toString()
    }

    private fun removeAndReverse(u: String): String {
        val sb = StringBuilder()
        val center = u.substring(1, u.length - 1)

        for (i in 0 until center.length) {
            if (center[i] == '(') 
                sb.append(')')
            if (center[i] == ')')
                sb.append('(')
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
}