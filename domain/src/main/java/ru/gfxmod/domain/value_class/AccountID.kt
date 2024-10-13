package ru.gfxmod.domain.value_class

@JvmInline
value class AccountID(val accountId: Int) {
    override fun toString(): String {
        return "$accountId"
    }
}
