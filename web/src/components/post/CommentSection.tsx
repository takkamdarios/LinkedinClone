import UserAvatar from '../user_avatar/UserAvatar'
import './CommentSection.css'
import { CommentInfo } from '../../utils/post-info'
import CommentCard from './CommentCard';
import { ChangeEvent, useState } from 'react';
import postAPI from '../../api/postAPI';

interface Props
{
    postId: number;
    comments: CommentInfo[];
}

export default function CommentSection({ postId, comments: initialComments }: Props)
{
    const [commentContent, setCommentContent] = useState('');
    const [comments, setComments] = useState<CommentInfo[]>(initialComments);

    const handleKeyDown = async (event: React.KeyboardEvent) =>
    {
        if (event.key === 'Enter' && commentContent.trim() !== '')
        {
            try
            {
                const newComment = await postAPI.addComment(postId, commentContent);
                setComments(prevComments => [...prevComments, newComment]);
                setCommentContent('');
            } catch (error)
            {
                alert('Failed to create post.');
            }

        }
    }

    const handleChange = (event: ChangeEvent<HTMLInputElement>) =>
    {
        setCommentContent(event.target.value);
    }

    return (
        <>
            {comments && (
                <div className="add-comment">
                    <UserAvatar />
                    <input
                        type="text"
                        placeholder="Add a comment..."
                        value={commentContent}
                        onChange={handleChange}
                        onKeyDown={handleKeyDown}
                    />
                </div>
            )}
            {comments && [...comments].sort((a, b) =>
                new Date(b.creationDate).getTime() - new Date(a.creationDate).getTime()).map((comment) =>
                (<CommentCard key={comment.id} comment={comment} />
                ))
            }
        </>
    )
}
