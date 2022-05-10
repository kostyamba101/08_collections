import org.junit.Test

import org.junit.Assert.*

class ContentServiceTest {

    @Test
    fun addNote() {
        val serviceNote = NotesService()
        val note = Note(id = 0)
        serviceNote.addContent(note)
        val expected = 0
        val result = note.id
        assertEquals(expected, result)
    }

    @Test
    fun addComment() {
        val serviceComment = CommentService()
        val comment = Comment(id = 0)
        serviceComment.addContent(comment)
        val expected = 0
        val result = comment.id
        assertEquals(expected, result)
    }

    @Test
    fun deleteNote() {
        val serviceNote = NotesService()
        val note = Note(id = 0)
        serviceNote.addContent(note)
        serviceNote.deleteContent(0)
        val expected = true
        val result = note.deleted
        assertEquals(expected, result)

    }

    @Test
    fun deleteComment() {
        val serviceComment = CommentService()
        val comment = Comment(id = 0)
        serviceComment.addContent(comment)
        serviceComment.deleteContent(0)
        val expected = true
        val result = comment.deleted
        assertEquals(expected, result)
    }

    @Test
    fun updateNote() {
        val serviceNote = NotesService()
        val note = Note(0, 0, "text1", false)
        serviceNote.addContent(note)
        val result = serviceNote.update(Note(id = 0, ownerId = 1))
        assert(result)
    }

    @Test(expected = NotFoundException::class)
    fun updateNoteNoNote() {
        val serviceNote = NotesService()
        val note = Note(0, 0, "text1", false)
        serviceNote.addContent(note)
        serviceNote.update(Note(id = 1, ownerId = 1))
    }

    @Test
    fun updateComment() {
        val serviceComment = CommentService()
        val comment = Comment(id = 0)
        serviceComment.addContent(comment)
        val result = serviceComment.update(Comment(id = 0, text = "text update"))
        assert(result)
    }

    @Test(expected = NotFoundException::class)
    fun updateCommentNoComment() {
        val serviceComment = CommentService()
        val comment = Comment(id = 0)
        serviceComment.addContent(comment)
        serviceComment.update(Comment(id = 1, text = "text update"))
    }

    @Test
    fun getById() {
        val serviceNote = NotesService()
        val note = Note(id = 0)
        serviceNote.addContent(note)
        serviceNote.getById(0)
    }

    @Test(expected = NotFoundException::class)
    fun restoreNoteNoNote() {
        val serviceNote = NotesService()
        val note = Note(id = 0)
        serviceNote.addContent(note)
        serviceNote.deleteContent(1)
    }

    @Test(expected = NotFoundException::class)
    fun restoreCommentNoComment() {
        val serviceComment = CommentService()
        val comment = Comment(id = 0)
        serviceComment.addContent(comment)
        serviceComment.deleteContent(1)
    }
}