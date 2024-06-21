import { useEffect, useState } from 'react';
import './Feed.css';
import InputOption from './InputOption';
import { CalendarViewDay, Image, MessageSharp } from '@material-ui/icons';
import Post from '../../../components/post/PostCard';
import { PostInfo } from '../../../utils/post-info';
import { Link } from 'react-router-dom';
import postAPI from '../../../api/postAPI';
import CircularProgress from '@material-ui/core/CircularProgress';
import UserAvatar from '../../../components/user_avatar/UserAvatar';



export default function Feed()
{
    const [posts, setPosts] = useState<PostInfo[]>([]);
    const [isLoading, setIsLoading] = useState(false);
    useEffect(() =>
    {
        const fetchPosts = async () =>
        {
            setIsLoading(true);
            try
            {
                const fetchedPosts = await postAPI.getAllPosts();
                setPosts(fetchedPosts);
            } catch (error)
            {
                console.error('Failed to fetch posts:', error);
            }
            setIsLoading(false);
        };

        fetchPosts();
    }, []);

    return (
        <div className='feed'>
            {isLoading ? (
                <CircularProgress />
            ) : (
                <>
                    <div className="feed_inputContainer">
                        <div className='feed_topInput'>
                            <UserAvatar />
                            <Link to='/new-post' className="feed_input">
                                Write a new post
                            </Link>

                        </div>
                        <div className="feed_inputOptions">
                            <InputOption title='Media' Icon={Image} color='#70B5F9' />
                            <InputOption title='Contribute expertise' Icon={MessageSharp} color='#E7A33E' />
                            <InputOption title='Write article' Icon={CalendarViewDay} color='#7FC15E' />
                        </div>
                    </div>
                    {
                        posts && posts.map((post) => (
                            <Post key={post.id} post={post}/>
                        ))
                    }
                </>
            )}
        </div>);
}