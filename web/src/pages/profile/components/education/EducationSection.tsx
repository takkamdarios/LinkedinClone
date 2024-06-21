import { EducationInfo } from "../../../../utils/profile-info";
import './EducationSection.css';

interface Props
{
    educations: EducationInfo[];
}

export default function EducationSection({educations}: Props) {
  return (
      <div className="educations">
          <h2>Educations</h2>
          {educations.map((education) => (
              <div key={education.id}>
                  <h3>{education.school}</h3>
                  <p>Degree: {education.degree}</p>
                  <p>Field of Study: {education.filedOfStudy}</p>
                  <p>Start Date: {new Date(education.startDate).toLocaleDateString()}</p>
                  <p>End Date: {new Date(education.endDate).toLocaleDateString()}</p>
              </div>
          ))}
      </div>
  )
}
