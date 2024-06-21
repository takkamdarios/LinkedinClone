import React from 'react';

const NotFoundPage: React.FC = () => {
    return (
        <div className="container mx-auto px-4 py-6">
            <div className="bg-white shadow overflow-hidden sm:rounded-lg p-4">
                <h1 className="text-3xl font-bold text-center text-gray-800">404 Not Found</h1>
                <p className="text-center text-gray-600 mt-4">
                    The page you're looking for doesn't exist.
                </p>
                <div className="mt-6 text-center">
                    <a href="/" className="text-blue-500 hover:text-blue-700">
                        Go back to HomePage
                    </a>
                </div>
            </div>
        </div>
    );
};

export default NotFoundPage;
