
import { ExperienceInfo } from '../../../../utils/profile-info';
import ExperienceCard from './ExperienceCard';
import './ExperienceSection.css'

interface Props
{
    experiences: ExperienceInfo[];
}

export default function ExperienceSection({ experiences }: Props)
{
    return (
        <div className="experiences">
            <div className="experiences_header">
                <h2>Experiences</h2>
            </div>
            {
                experiences && experiences.map((experience) => (
                    <ExperienceCard key={experience.id} experience={experience} />
                ))
            }
        </div>
    )
}
