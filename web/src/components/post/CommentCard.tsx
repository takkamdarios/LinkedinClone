import { Link } from 'react-router-dom'
import UserAvatar from '../user_avatar/UserAvatar'
import './CommentCard.css'
import { CommentInfo } from '../../utils/post-info'
import FormatDate from '../../utils/format-date';

interface Props
{
    comment: CommentInfo;
}

export default function CommentCard({ comment }: Props)
{
    return (
        <div className="comment">
            <div className="comment_avatar">
                <Link to={`/profile/${comment.profile.id}`}>
                    <UserAvatar />
                </Link>
            </div>
            <div className="comment_header">
                <div className="comment_info">
                    <Link to={`/profile/${comment.profile.id}`}>
                        {comment.profile.user.firstName + ' ' + comment.profile.user.lastName}
                    </Link>
                    <p>{comment.profile.summary}</p>
                    <p>{FormatDate(comment.creationDate)}</p>
                </div>
                <div className="comment_content">
                    <p>{comment.content}</p>
                </div>
            </div>
        </div>
    )
}
