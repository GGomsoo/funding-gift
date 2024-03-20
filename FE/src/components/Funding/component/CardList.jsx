import Card from "../component/Card";

function CardList({data}){
    return (
        <div className="flex flex-wrap justify-center">
            {data.map((data, index) => (
                <Card key = {index} title = {data.title} name = {data.name} date = {data.date} progress={data.progress}/>
            ))}
        </div>
    )
}

export default CardList