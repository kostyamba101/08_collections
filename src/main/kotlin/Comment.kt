data class Comment(
    override val id: Int,
    val ownerId: Int? = null,
    val text: String? = null,
    override var deleted: Boolean = false
) : Content(id, deleted)
