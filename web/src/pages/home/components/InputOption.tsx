import { OverridableComponent } from "@material-ui/core/OverridableComponent";
import { SvgIconTypeMap } from "@material-ui/core/SvgIcon/SvgIcon";
import './InputOption.css'

interface Props
{
    title: string;
    Icon?: OverridableComponent<SvgIconTypeMap<object, "svg">>;
    color: string;
}

export default function InputOption({ title, Icon, color}: Props)
{
    
  return (
      <div className="inputOption">
          {Icon && <Icon style={{ color }}/>}
          <h4>{title}</h4>
      </div>
  )
}
