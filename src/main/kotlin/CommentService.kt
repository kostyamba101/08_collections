class CommentService : ContentService<Comment>() {
    fun restoreComment(id: Int): Boolean {
        val comment = this.getById(id)
        if (comment != null) {
            comment.deleted = false
        }
        throw NotFoundException("Контент не найден")
    }

    fun getComments(id: Int): MutableList<Comment>? {
        val comments = mutableListOf<Comment>()
        for ((index, item) in items.withIndex()) if (item.id == id) {
            comments.add(item)
        }
        return comments
    }

    fun deleteAllForNote(id: Int): Boolean {
        var result = false
        for ((index, item) in items.withIndex()) if (item.id == id) {
            item.deleted = true
            result = true
        }
        return result
    }
}