import './Sidebar.css';
import UserAvatar from '../../../components/user_avatar/UserAvatar';

export default function Sidebar()
{
    const recentItem = (topic: string) =>
    (
        <div className='sidebar_recentItem'>
            <span className='sidebar_hash'>#</span>
            <p>{topic}</p>
        </div>
    );
    return (
        <div className='sidebar'>
            <div className='sidebar_top'>
                <img src="https://img.freepik.com/free-vector/abstract-digital-science-fiction-matrix-like-background_587448-971.jpg" alt="profile_banner" />
                <UserAvatar />
                <h2 className='sidebar_name'>Jonathan Nelson</h2>
                <h4 className='sidebar_email'>Firefighter</h4>
            </div>
            <div className='sidebar_stats'>
                <div className='sidebar_stat'>
                    <p>Profile viewers</p>
                    <p className='sidebar_statNumber'>1,487</p>
                </div>
                <div className='sidebar_stat'>
                    <p>Post viewers</p>
                    <p className='sidebar_statNumber'>3,214</p>
                </div>
            </div>
            <div className='sidebar_bottom'>
                <p>Recent</p>
                {recentItem("programming")}
                {recentItem("reactjs")}
                {recentItem("springboot")}
                {recentItem("flutter")}
                {recentItem("dataengineering")}
                {recentItem("datascience")}
            </div>
        </div>
    )
}
