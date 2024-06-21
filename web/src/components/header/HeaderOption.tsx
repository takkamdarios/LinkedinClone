import { SvgIconTypeMap } from "@material-ui/core";
import { OverridableComponent } from "@material-ui/core/OverridableComponent";
import './HeaderOption.css'
import { NavLink } from 'react-router-dom';

interface Props
{
  title: string;
  Icon?: OverridableComponent<SvgIconTypeMap<object, "svg">>;
  path: string;
}

export default function HeaderOption({ title, Icon, path}: Props)
{
  return (
    <NavLink className={({ isActive }) => "headerOption" + (isActive ? " active" : "")} to={path}>
      {Icon && <Icon/>}
     <h3 className="headerOption_title">{title}</h3>
    </NavLink>
  )
}