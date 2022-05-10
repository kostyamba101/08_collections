open class ContentService<T : Content> {

    val items = mutableListOf<T>()

    fun addContent(item: T): Boolean {
        items.add(item)
        return true
    }

    fun update(updatedContent: T): Boolean {
        for ((index, item) in items.withIndex()) {
            if (item.id == updatedContent.id) {
                items[index] = updatedContent
                return true
            }
        }
        throw NotFoundException("Контент не найден")
    }

    fun deleteContent(id: Int): Boolean {
        for ((index, item) in items.withIndex()) {
            if (item.id == id) {
                items[index].deleted = true
                return true
            }
        }
        throw NotFoundException("Контент не найден")
    }

    fun getList(): List<T> {
        return items.toList()
    }

    fun getById(id: Int): T? {
        return items.findLast { it.id == id }
    }
}