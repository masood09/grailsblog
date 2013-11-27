package grailsblog

import org.apache.commons.lang.builder.HashCodeBuilder

class PostCategory implements Serializable {

    private static final long serialVersionUID = 1

    Post post
    Category category

    boolean equals(other) {
        if (!(other instanceof PostCategory)) {
            return false
        }

        other.post?.id == post?.id &&
            other.category?.id == category?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (post) builder.append(post.id)
        if (category) builder.append(category.id)
        builder.toHashCode()
    }

    static PostCategory get(long postId, long categoryId) {
        PostCategory.where {
            post == Post.load(postId) &&
            category == Category.load(categoryId)
        }.get()
    }

    static PostCategory create(Post post, Category category, boolean flush = false) {
        new PostCategory(post: post, category: category).save(flush: flush, insert: true)
    }

    static boolean remove(Post p, Category c, boolean flush = false) {

        int rowCount = PostCategory.where {
            post == Post.load(p.id) &&
            category == Category.load(c.id)
        }.deleteAll()

        rowCount > 0
    }

    static void removeAll(Post p) {
        PostCategory.where {
            post == Post.load(p.id)
        }.deleteAll()
    }

    static void removeAll(Category c) {
        PostCategory.where {
            category == Category.load(c.id)
        }.deleteAll()
    }

    static mapping = {
        id composite: ['post', 'category']
        version false
    }
}
