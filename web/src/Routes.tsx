import { Navigate } from "react-router-dom";
import HomePage from "./pages/home/HomePage";
import PostPage from "./pages/post/PostPage";
import NotFoundPage from "./pages/NotFoundPage";
import ProfilePage from "./pages/ProfilePage";
import NotificationsPage from "./pages/NotificationsPage";
import NetworkPage from "./pages/NetworkPage";
import JobsPage from "./pages/JobsPage";
import MessagingPage from "./pages/MessagingPage";
import { Routes, Route } from 'react-router-dom';
import NewPostPage from "./pages/NewPostPage";
import UserProfilePage from "./pages/profile/UserProfilePage";


export default function CustomRoutes()
{
    return (
        <Routes>
            <Route path="/" element={<Navigate to="/home" />} />
            <Route path="/home" element={<HomePage />} />
            <Route path="/messaging" element={<MessagingPage />} />
            <Route path="/network" element={<NetworkPage />} />
            <Route path="/jobs" element={<JobsPage />} />
            <Route path="/notifications" element={<NotificationsPage />} />
            <Route path="/profile" element={<ProfilePage />} />
            <Route path="/new-post" element={<NewPostPage />} />
            <Route path="/post/:id" element={<PostPage />} />
            <Route path="/profile/:id" element={<UserProfilePage />} />
            <Route path="*" element={<NotFoundPage />} />
        </Routes>
    )
}
