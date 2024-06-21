import './Footer.css'

export default function Footer()
{
    return (
        <div className="footer">
            <ul className='footer_pages'>
                <li><a href="#">About</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Terms</a></li>
            </ul>
            <p className="footer_copyright">
                © {new Date().getFullYear()} LinkedIn Clone. All rights reserved.
            </p>
        </div>
    );
}