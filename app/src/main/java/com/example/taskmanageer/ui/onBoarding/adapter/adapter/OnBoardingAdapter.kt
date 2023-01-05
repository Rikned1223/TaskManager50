package com.example.taskmanageer.ui.onBoarding.adapter.adapter

class OnBoardingAdapter(
    private val context: Context,
    private val onClick:() -> Unit
) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {


    private val data = arrayListOf(
        OnBoard(R.raw.animation, "It's available in your favorite cities nowand thy wait! go and orderfour favorite juices"),
        OnBoard(R.raw.animation_two, "Juice is a beverage made from theextraction or pressing out of natural liquidcontained good quality fruitsfour favorite juices"),
        OnBoard(R.raw.animation_three, "User can look for their favorite juicesand buy it through the online gatewayprocess or through cash on delivery")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemBoardingBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.ivBoarding.setAnimation(onBoard.image!!)

            if (adapterPosition == data.lastIndex) {
                binding.tvSkip.text = context.getString(R.string.next)
            } else binding.tvSkip.text = context.getString(R.string.skip)
            binding.tvSkip.setOnClickListener {
                onClick()
            }
        }


    }
}