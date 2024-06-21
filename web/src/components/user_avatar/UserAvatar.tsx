import { USER_AVATAR_URL } from '../../utils/user-avatar'
import './UserAvatar.css'

export default function UserAvatar()
{
  return (
    <div>
      <img className='user_avatar' src={USER_AVATAR_URL} alt="User Profile Picture" />
    </div>
  )
}
