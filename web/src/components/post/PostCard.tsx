import './PostCard.css'
import InputOption from '../../pages/home/components/InputOption';
import { InsertCommentOutlined, LoopOutlined, SendOutlined, ThumbUpAltOutlined } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import UserAvatar from '../user_avatar/UserAvatar';
import { PostInfo } from '../../utils/post-info';
import CommentSection from './CommentSection';
import FormatDate from '../../utils/format-date';

interface Props
{
    post: PostInfo;
    isPostPage?: boolean;
}

export default function PostCard({ post, isPostPage = false }: Props)
{
    return (
        <div className='post'>
            <Link to={`/profile/${post.profile.id}`}>
                <div className="post_header">
                    <UserAvatar />
                    <div className="post_info">
                        <strong>{post.profile.user.firstName + ' ' + post.profile.user.lastName}</strong>
                        <p>{post.profile.summary}</p>
                        <p>{FormatDate(post.creationDate)}</p>
                    </div>
                </div>
            </Link>
            <div className="post_body">
                <h3>{post.title}</h3>
                <p>
                    {isPostPage ? post.content : post.content.length > 50 ? post.content.slice(0, 50) : post.content}
                    {post.content.length > 50 &&
                        !isPostPage &&
                        <Link to={`/post/${post.id}`} className="post_see-more">
                            ...see more
                        </Link>}
                </p>
            </div>
            <div className="post_buttons">
                <InputOption Icon={ThumbUpAltOutlined} title='Like' color='gray' />
                <Link to={`/post/${post.id}`}>
                    <InputOption Icon={InsertCommentOutlined} title='Comment' color='gray' />
                </Link>
                <InputOption Icon={LoopOutlined} title='Repost' color='gray' />
                <InputOption Icon={SendOutlined} title='Send' color='gray' />
            </div>
            <CommentSection postId={post.id} comments={post.comments} />
        </div>
    )
}
