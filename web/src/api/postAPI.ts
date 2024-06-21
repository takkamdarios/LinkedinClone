import { baseURL } from "./baseURL";

const API_URL = baseURL + '/api/posts'; 

const postAPI = {
    getAllPosts: async () =>
    {
        try
        {
            const response = await fetch(API_URL);
            if (!response.ok)
            {
                throw new Error('Network response was not ok');
            }
            const posts = await response.json();
            posts.sort((a: { creationDate: Date; }, b: { creationDate: Date; }) =>
                new Date(b.creationDate).getTime() - new Date(a.creationDate).getTime());
            return posts;  
        } catch (error)
        {
            console.error('Error fetching posts:', error);
            throw error;  
        }
    },

    getPostByProfileId: async (id: string) =>
    {
        try
        {
            const response = await fetch(`${API_URL}/profile/${id}`);
            if (!response.ok)
            {
                throw new Error(`Failed to fetch post with id ${id}`);
            }
            return await response.json();  
        } catch (error)
        {
            console.error(`Error fetching post with id ${id}:`, error);
            throw error;  
        }
    },


    getPostById: async (id: string) =>
    {
        try
        {
            const response = await fetch(`${API_URL}/${id}/with-comments`);
            if (!response.ok)
            {
                throw new Error(`Failed to fetch post with id ${id}`);
            }
            return await response.json();  
        } catch (error)
        {
            console.error(`Error fetching post with id ${id}:`, error);
            throw error;  
        }
    },


    createPost: async (post: { title: string; content: string }) =>
    {

        try
        {
            const response = await fetch(API_URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ ...post, profileId: 96 })  
            });
            if (!response.ok)
            {
                throw new Error('Failed to create post');
            }
            return await response.json();  
        } catch (error)
        {
            console.error('Error creating post:', error);
            throw error;  
        }
    },

    addComment: async (postId:number , commentContent: string ) =>
    {
        try
        {
            const response = await fetch(`${API_URL}/${postId}/comments`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ content: commentContent, profileId: 96 })
            });
            if (!response.ok)
            {
                throw new Error('Failed to create post');
            }
            return await response.json();
        } catch (error)
        {
            console.error('Error creating post:', error);
            throw error;
        }
    },
};

export default postAPI;
