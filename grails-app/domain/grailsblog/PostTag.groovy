package grailsblog

import org.apache.commons.lang.builder.HashCodeBuilder

class PostTag implements Serializable {

    private static final long serialVersionUID = 1

    Post post
    Tag tag

    boolean equals(other) {
        if (!(other instanceof PostTag)) {
            return false
        }

        other.post?.id == post?.id &&
            other.tag?.id == tag?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (post) builder.append(post.id)
        if (tag) builder.append(tag.id)
        builder.toHashCode()
    }

    static PostTag get(long postId, long tagId) {
        PostTag.where {
            post == Post.load(postId) &&
            tag == Tag.load(tagId)
        }.get()
    }

    static PostTag create(Post post, Tag tag, boolean flush = false) {
        new PostTag(post: post, tag: tag).save(flush: flush, insert: true)
    }

    static boolean remove(Post p, Tag t, boolean flush = false) {

        int rowCount = PostTag.where {
            post == Post.load(p.id) &&
            tag == Tag.load(t.id)
        }.deleteAll()

        rowCount > 0
    }

    static void removeAll(Post p) {
        PostTag.where {
            post == Post.load(p.id)
        }.deleteAll()
    }

    static void removeAll(Tag t) {
        PostTag.where {
            tag == Tag.load(t.id)
        }.deleteAll()
    }

    static mapping = {
        id composite: ['post', 'tag']
        version false
    }
}
