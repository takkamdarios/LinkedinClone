import { useEffect, useState } from 'react';
import { PostInfo } from '../../../../utils/post-info';
import './ActivitySection.css'
import postAPI from '../../../../api/postAPI';
import { CircularProgress } from '@material-ui/core';
import PostCard from './../../../../components/post/PostCard'
import { Link } from 'react-router-dom';

interface Props
{
    profileId: string;
}

export default function ActivitySection({ profileId }: Props)
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
                const fetchedPosts = await postAPI.getPostByProfileId(profileId.toString());
                setPosts(fetchedPosts);
            } catch (error)
            {
                console.error('Failed to fetch posts:', error);
            }
            setIsLoading(false);
        };

        fetchPosts();
    }, [profileId]);
    return (
        <div className="activity-section">
            {isLoading ? (
                <CircularProgress />
            ) : (
                <>
                    <div className="activity-header">
                        <h2>Activity</h2>
                        <p>809 followers</p>
                        <Link to='/new-post'>
                            <button className="create-post">Create a post</button>
                        </Link>
                    </div>
                    <div className="tabs">

                        <button className="tab active">Posts</button>

                        <button className="tab">Comments</button>
                    </div>
                    {
                        posts && posts.slice(-2).map((post) => (
                            <PostCard key={post.id} post={post}  />
                        ))
                    }
                    {
                        posts.length > 2 && (
                            <div className="show-all-posts">
                                <a href="#">Show all posts →</a>
                            </div>
                        )
                    }
                </>
            )}
        </div>
    );
}
