import React, { useState } from 'react';
import postAPI from '../api/postAPI'; 
import { useNavigate } from 'react-router-dom';

const NewPostPage: React.FC = () => {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();
        try {
            await postAPI.createPost({ title, content });
            setTitle('');  
            setContent('');
            alert('Post created successfully!');
            navigate('/');
        } catch (error) {
            console.error('Error creating post:', error);
            alert('Failed to create post.');
        }
    };

    return (
        <div className="container mx-auto px-4">
            <h1 className="text-2xl font-semibold text-gray-800 my-6">Create New Post</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    placeholder="Title"
                    className="block w-full p-2 border rounded mb-2"
                />
                <textarea
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    placeholder="Content"
                    className="block w-full p-2 border rounded mb-2"
                    rows={4}
                />
                <button type="submit" className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-700">Post</button>
            </form>
        </div>
    );
};

export default NewPostPage;
