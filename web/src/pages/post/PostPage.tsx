import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import postAPI from '../../api/postAPI';
import { PostInfo } from '../../utils/post-info';
import PostCard from '../../components/post/PostCard';
import './PostPage.css';

const PostPage: React.FC = () =>
{
    const { id } = useParams<{ id: string }>();
    const [post, setPost] = useState<PostInfo>();

    useEffect(() =>
    {
        const fetchPost = async () =>
        {
            try
            {
                const fetchedPost = await postAPI.getPostById(id ?? '');
                setPost(fetchedPost);
            } catch (error)
            {
                console.error('Failed to fetch post:', error);
            }
        };

        fetchPost();
    }, [id]);

    return (
        <div className="post_page">
            {post ? (
                <PostCard post={post} isPostPage={true} />
            ) : (
                <p>Loading post...</p>
            )}
        </div>

    );
};

export default PostPage;
