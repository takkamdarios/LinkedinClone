import SearchIcon from '@material-ui/icons/Search';
import './Header.css';
import './HeaderOption.css';
import HeaderOption from './HeaderOption';
import HomeIcon from '@material-ui/icons/Home';
import SupervisorAccountIcon from '@material-ui/icons/SupervisorAccount';
import BusinessCenterIcon from '@material-ui/icons/BusinessCenter';
import ChatIcon from '@material-ui/icons/Chat'
import NotificationsIcon from '@material-ui/icons/Notifications'
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import { Link } from 'react-router-dom';

export default function Header()
{
    return (
        <div className="header">
            <div className='header_left'>
                <Link to='/home' className='header_left'>
                    <img src="https://cdn-icons-png.flaticon.com/512/174/174857.png" alt="linkedin_logo" />
                </Link>
                <div className='header_search'>
                    <SearchIcon />
                    <input type="text" />
                </div>
            </div>
            <div className='header_right'>
                <HeaderOption title='Home' Icon={HomeIcon} path='/home' />
                <HeaderOption title='My Network' Icon={SupervisorAccountIcon} path='/network' />
                <HeaderOption title='Jobs' Icon={BusinessCenterIcon} path='/jobs' />
                <HeaderOption title='Messaging' Icon={ChatIcon} path='/messaging' />
                <HeaderOption title='Notifications' Icon={NotificationsIcon} path='/notifications' />
                <HeaderOption title='Me' Icon={AccountCircleIcon} path='/profile' />
            </div>
        </div>
    )
}
